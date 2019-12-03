const productsUrl = '/products/c/';

jQuery(function ($) {
    $.ajax({
        type: "GET",
        url: "/api/categories",
        dataType: "json",
        success: function (response) {
            $.each(response, function (index, element) {
                renderCategories(element);
            });
        }
    });

    function renderCategories(category) {
        let categoryDropDownId = 'CAT' + category.code;
        $('#categoriesNav').append(
            '<ul class=\"navbar-nav\">' +
            '<li class="nav-item dropdown dropdown-hover">' +
            '<a class="nav-link" href="' + productsUrl + category.code + '">' + category.name + '</a>' +
            '<div id="' + categoryDropDownId + '" class="dropdown-menu" aria-labelledby="navbarDropdown">');

        renderChildCategories();

        function renderChildCategories() {
            $.each(category.childCategories, function (index, childCategory) {
                $('#' + categoryDropDownId + '').append(
                    '<a class="dropdown-item" href= "' + productsUrl + childCategory.code + '">' + childCategory.name + '</a>')
            });

        }

        $('.dropdown-hover').hover(function () {
            $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(200);
        }, function () {
            $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(200);
        });
    }
});

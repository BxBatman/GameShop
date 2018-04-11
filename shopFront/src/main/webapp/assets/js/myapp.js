$(function () {
    switch (menu) {
        case 'O nas':
            $('#about').addClass('active');
            break;
        case 'Kontakt':
            $('#contact').addClass('active');
            break;

        case 'Wszystkie produkty':
            $('#listProducts').addClass('active');
            break;
        case 'Zarz±dzaj produktami':
            $('#manageProducts').addClass('active');
            break;
        case 'Koszyk':
            $('#userCart').addClass('active');
        default:
            $('#a_' + menu).addClass('active');
            break;

    }

    var token = $('meta[name="_csrf"]').attr('content');
    var header = $('meta[name="_csrf_header"]').attr('content');

    if (token.length > 0 && header.length > 0) {
        $(document).ajaxSend(function (e, xhr, options) {
            xhr.setRequestHeader(header, token);
        })

    }


    var $table = $('#productListTable');


    //execute where we have this table

    if ($table.length) {

        var jsonUrl = '';
        if (window.categoryId == '') {
            jsonUrl = window.contextRoot + '/json/data/all/products';
        } else {
            jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId + '/products';
        }

        $table.DataTable({
            language: {
                "lengthMenu": "Poka¿ _MENU_ na stronê",
                "zeroRecords": "Nic nie znaleziono",
                "info": "Strony od _PAGE_ do _PAGES_",
                "search": "Szukaj",
                "paginate": {
                    "first": "Pierwszy",
                    "last": "Ostatni",
                    "next": "Nastêpny",
                    "previous": "Wstecz"
                }
            },
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },

            columns: [
                {
                    data: 'code',
                    mRender: function (data, type, row) {
                        return '<img src="' + window.contextRoot + '/resources/images/' + data + '.jpg" class="dataTableImg"/>'
                    }
                },

                {
                    data: 'name'
                },
                {
                    data: 'brand'
                },
                {
                    data: 'unitPrice',
                    mRender: function (data, type, row) {
                        return data + " z³";
                    }
                },
                {
                    data: 'quantity',
                    mRender: function (data, type, row) {
                        if (data < 1) {
                            return '<span style="color:red">Wyprzedane</span>';
                        }
                        return data;
                    }
                },
                {
                    data: 'id',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += '<a href="' + window.contextRoot + '/show/' + data + '/product" class="btn btn-sm btn-primary">Zobacz</a> &#160';
                        if (userRole == 'ADMIN') {
                            str += '<a href="' + window.contextRoot + '/manage/' + data + '/product" class="btn btn-sm btn-warning">Edytuj</a>';

                        } else {
                            if (row.quantity < 1) {
                                str += '<a href="javascript:void(0)" class="btn btn-sm btn-primary disabled">Dodaj do koszyka</a>';
                            } else {
                                str += '<a href="' + window.contextRoot + '/cart/add/' + data + '/product" class="btn btn-sm btn-primary">Dodaj do koszyka</a>';
                            }
                        }
                        return '<div class="btn-group-vertical">' + str + '</div>';
                    }
                }
            ]
        });
    }


    var $alert = $('.alert');

    if ($alert.length) {
        setTimeout(function () {
            $alert.fadeOut('slow');
        }, 3000)
    }


    $('.switch input[type="checkbox"]').on('change', function () {
        var checkbox = $(this);
        var checked = checkbox.prop('checked');
        var dMsg = (checked) ? 'Czy chcesz uaktywniæ produkt?' :
            'Czy chcesz dezaktywowaæ produkt?';
        var value = checkbox.prop('value');

        bootbox.confirm({
            size: 'medium',
            message: dMsg,
            buttons: {
                confirm: {
                    label: 'Tak'
                },
                cancel: {
                    label: 'Anuluj'
                }

            },
            callback: function (confirmed) {
                if (confirmed) {
                    console.log(value);
                    bootbox.alert({
                        size: 'medium',
                        message: 'Wykona³e¶ operacje na produkcie o id: ' + value
                    });
                } else {
                    checkbox.prop('checked', !checked);
                }
            }
        });
    });


    var $adminProductsTable = $('#adminProductsTable');


    //execute where we have this table

    if ($adminProductsTable.length) {

        var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

        $adminProductsTable.DataTable({
            language: {
                "lengthMenu": "Poka¿ _MENU_ na stronê",
                "zeroRecords": "Nic nie znaleziono",
                "info": "Strony od _PAGE_ do _PAGES_",
                "search": "Szukaj",
                "paginate": {
                    "first": "Pierwszy",
                    "last": "Ostatni",
                    "next": "Nastêpny",
                    "previous": "Wstecz"
                }
            },
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },

            columns: [
                {
                    data: 'id'
                },
                {
                    data: 'code',
                    mRender: function (data, type, row) {
                        return '<img src="' + window.contextRoot + '/resources/images/' + data + '.jpg" class="adminDataTableImg"/>';
                    }
                },

                {
                    data: 'name'
                },
                {
                    data: 'quantity',
                    mRender: function (data, type, row) {
                        if (data < 1) {
                            return '<span style="color:red">Wyprzedane</span>';
                        }
                        return data;
                    }
                },
                {
                    data: 'unitPrice',
                    mRender: function (data, type, row) {
                        return data + " z³";
                    }
                },
                {
                    data: 'active',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = "";
                        str += '<label class="switch">';
                        if (data) {
                            str += '<input type="checkbox" checked="checked" value="' + row.id + '" />';
                        }
                        else {
                            str += '<input type="checkbox" value="' + row.id + '" />';
                        }
                        str += '<div class="slider"></div>';
                        str += '</label>';

                        return str;
                    }

                },
                {
                    data: 'id',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += '<a href="' + window.contextRoot + '/manage/' + data + '/product" class="btn btn-warning">';
                        str += '<span >Edit</span>';
                        str += '</a>';

                        return str;
                    }
                }
            ],
            initComplete: function () {
                var api = this.api();
                api.$('.switch input[type="checkbox"]').on('change', function () {
                    var checkbox = $(this);
                    var checked = checkbox.prop('checked');
                    var dMsg = (checked) ? 'Czy chcesz uaktywniæ produkt?' :
                        'Czy chcesz dezaktywowaæ produkt?';
                    var value = checkbox.prop('value');

                    bootbox.confirm({
                        size: 'medium',
                        message: dMsg,
                        buttons: {
                            confirm: {
                                label: 'Tak'
                            },
                            cancel: {
                                label: 'Anuluj'
                            }

                        },
                        callback: function (confirmed) {
                            if (confirmed) {
                                console.log(value);


                                var activationUrl = window.contextRoot + '/manage/product/' + value + '/activation';

                                $.post(activationUrl, function (data) {
                                    bootbox.alert({
                                        size: 'medium',
                                        message: data
                                    });
                                });


                            } else {
                                checkbox.prop('checked', !checked);
                            }
                        }
                    });
                });

            }
        });
    }

    var $categoryForm = $('#categoryForm');

    if ($categoryForm.length) {
        $categoryForm.validate({
                rules: {
                    name: {
                        required: true,
                        minlength: 2

                    },
                    description: {
                        required: true

                    }
                },
                messages: {
                    name: {
                        required: 'Prosze dodac nazwe kategorii',
                        minlength: "Nazwa musi miec conajmniej 2 znaki"
                    },
                    description: {
                        required: 'Prosze dodac opis'
                    }
                },
                errorElement: 'em',
                errorPlacement: function (error, element) {
                    error.addClass('help-block');
                    error.insertAfter(element);
                }
            }
        );
    }

    //validation for login


    var $loginForm = $('#loginForm');

    if ($loginForm.length) {
        $loginForm.validate({
                rules: {
                    username: {
                        required: true,
                        email: true

                    },
                    password: {
                        required: true

                    }
                },
                messages: {
                    username: {
                        required: 'Prosze wpisac login',
                        email: "Prosze wpisac poprawny email"
                    },
                    password: {
                        required: 'Prosze wpisac haslo'
                    }
                },
                errorElement: 'em',
                errorPlacement: function (error, element) {
                    error.addClass('help-block');
                    error.insertAfter(element);
                }
            }
        );
    }

    $('button[name="refreshCart"]').click(function () {
        var cartLineId = $(this).attr('value');
        var countElement = $('#count_' + cartLineId);
        var originalCount = countElement.attr('value');
        var currentCount = countElement.val();


        if (currentCount !== originalCount) {
            if(currentCount < 1 || currentCount >3){
                countElement.val(originalCount);
                bootbox.alert({
                   size: 'medium',
                    message: 'Produkt mo¿e mieæ minimaln± ilo¶æ 1 oraz maksymalna 3'
                });
            }else{
                var updateUrl = window.contextRoot+'/cart/'+cartLineId + '/update?count=' + currentCount;
                window.location.href = updateUrl;
            }

        }


    });


});
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
        default:
            $('#listProducts').addClass('active');
            $('#a_' + menu).addClass('active');
            break;

    }


            //code for jquery datatable
            //dataset

            var products = [
                ['1', 'abc'],
                ['2', 'cxd'],
                ['3', 'tdd'],
                ['4', 'aga'],
                ['5', 'dad'],
                ['6', 'aww'],
                ['4', 'aga'],
                ['5', 'dad'],
                ['6', 'aww'],
                ['4', 'aga'],
                ['5', 'dad'],
                ['6', 'aww'],
            ];

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
                                if (row.quantity < 1) {
                                    str += '<a href="javascript:void(0)" class="btn btn-sm btn-primary disabled">Dodaj do koszyka</a>';
                                } else {
                                    str += '<a href="' + window.contextRoot + '/cart/add/' + data + '/product" class="btn btn-sm btn-primary">Dodaj do koszyka</a>';
                                }
                                return str;
                            }
                        }
                    ]
                });
            }


            var $alert = $('.alert');

            if($alert.length){
                setTimeout(function(){
                    $alert.fadeOut('slow');
                },3000)
            }

    }
);
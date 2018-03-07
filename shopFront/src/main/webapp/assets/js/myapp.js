$(function(){
   switch(menu){
       case 'O nas':
           $('#about').addClass('active');
           break;
       case 'Kontakt':
           $('#contact').addClass('active');
           break;
       case 'Wszystkie produkty':
           $('#listProducts').addClass('active');
           break;
       default:
           $('#listProducts').addClass('active');
           $('#a_'+menu).addClass('active');
           break;

   }


   //code for jquery datatable
    //dataset

    var products = [
        ['1','abc'],
        ['2','cxd'],
        ['3','tdd'],
        ['4','aga'],
        ['5','dad'],
        ['6','aww'],
        ['4','aga'],
        ['5','dad'],
        ['6','aww'],
        ['4','aga'],
        ['5','dad'],
        ['6','aww'],
    ];

   var $table = $('#productListTable');


   //execute where we have this table

    if($table.length) {
       // console.log('Inside the table !');
        $table.DataTable({
            language : {
                "lengthMenu" : "Poka¿ _MENU_ na stronê",
                "zeroRecords" : "Nic nie znaleziono",
                "info" : "Strony od _PAGE_ do _PAGES_",
                "search": "Szukaj",
                "paginate": {
                    "first":      "Pierwszy",
                    "last":       "Ostatni",
                    "next":       "Nastêpny",
                    "previous":   "Wstecz"
                }
            },
            data : products
        });
    }

});
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
});
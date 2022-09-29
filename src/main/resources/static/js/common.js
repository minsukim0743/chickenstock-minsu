
    $(function(){
        function accordion (e){
          $('.accordion a').on("click", function(e){
            const _this = $(this)
            if( _this.siblings('ul').length) {
              e.preventDefault();
              _this.siblings('ul').stop().slideToggle(300);
              _this.toggleClass('hover');
            }
          });
        }
        accordion();
      });
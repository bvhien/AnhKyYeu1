$(function(){
	
	// ========= Điều chỉnh các thông số cho slideshow =========
	
		// Số lượng hình muốn hiển thị
		// Lượng hình tồn tại trong slide cần nhiều hơn con số này để slide có thể thực hiện chức năng xoay vòng
		var display_image_number = 4;
		
		// Lựa chọn cách thức xoay vòng (circle) của slide bằng cách thay đổi circle_method bằng các con số tương ứng
		// Method = 1: Sau khi chạm đến giới hạn slide, slide stage sẽ trượt thẳng về vị trí cuối cùng hoặc đầu tiên
		// Method = 2: Sau khi chạm đến giới hạn slide, slide sẽ được quay vòng qua từng hình
		var circle_method = 2;
		
		// Tốc độ dịch chuyển của hình ảnh (đơn vị: milisecond)
		var anispeed = 1000;
		
		// Lựa chọn có sử dụng chế độ tự động cuốn hình slide
		// 1 = Kích hoạt, 0 = Không kích hoạt
		var auto_scroll = 1;
		
		// Nếu giá trị auto_scroll = 1 thì có thể điều chỉnh giá trị sau để thay đổi thời gian cuộn
		var timeinterval = 3600;
		
	
	// ========= Xác định các thông số cơ bản của slideshow =========

	// Xác định số lượng hình của slide, chiều rộng của mỗi hình để tìm ra độ rộng của stage
	var image_count = $('#album-content .slide-image').length;
	var image_width = $('#album-content .slide-image').width();
		// Độ rộng của hình ảnh có thể chỉnh sửa bằng css
		// Độ rộng này quan trọng vì nó sẽ ảnh hưởng đến độ rộng của toàn bộ slide, cần được tính toán cẩn thận
	var stage_width = image_width * image_count;
	// Xác định chiều rộng của khung hiển thị slide
	var display_width = display_image_number * image_width;
	
	// Chỉnh độ dài slide stage tương ứng với số lượng hình cần hiển thị thông qua display_width
	$('#album-content .slide-holder').css("width", display_width + "px");
	
	// Chỉnh lại độ dài của khối bao quanh các slide-image (slide-stage) cho vừa bằng tổng số khối slide-image
	$('#album-content .slide-stage').css("width", stage_width + "px");
	

	// ========= Xử lý khi click nút next và prev =========
	
	function left_slide_circle(){
		$('#album-content .slide-image:last-child').addClass('swapthis'); // Xác định hình đang ở vị trí cuối cùng
		$('#album-content .swapthis').insertBefore('#album-content .slide-image:first'); // Chuyển hình cuối lên trước hình đầu tiên
		$('#album-content .slide-stage').css("left",-image_width + "px"); // Dịch chuyển tức thời vị trí của stage sang một khoảng bằng 1 slide-image
		$('#album-content .slide-stage').stop().animate({left:0},anispeed); // Thực hiện animation
		$('#album-content .swapthis').removeClass('swapthis'); // Reset class cho slide-image vừa chuyển
	}
	function right_slide_circle(){
		$('#album-content .slide-image:first').addClass('swapthis'); // Xác định hình đang ở vị trí cuối cùng
		$('#album-content .swapthis').insertAfter('#album-content .slide-image:last-child'); // Chuyển hình cuối lên trước hình đầu tiên
		$('#album-content .slide-stage').css("left",-(stage_width - image_width - display_width) + "px"); // Dịch chuyển tức thời vị trí của stage sang một khoảng bằng 1 slide-image
		$('#album-content .slide-stage').stop().animate({left:display_width - stage_width},anispeed); // Thực hiện animation
		$('#album-content .swapthis').removeClass('swapthis'); // Reset class cho slide-image vừa chuyển
	}
	function left_slide_scroll(){
		// Xác định xem slide có còn hình phía bên trái hay không dựa trên Left của stage
		var stage_left = $('#album-content .slide-stage').position().left;
		
		// Nếu có
		if(stage_left < 0 && !$('#album-content .slide-stage').is(':animated')){ //Kích hoạt chỉ khi stage ko chuyển động nữa
			$('#album-content .slide-stage').stop().animate({left:"+=" + image_width},anispeed);
		}
		else // Nếu đã chuyển về hình ảnh đầu tiên thì lựa chọn cách thức quay vòng
		{	
			switch(circle_method){ //Lựa chọn
				case 1:
					$('#album-content .slide-stage').stop().animate({left:display_width - stage_width},anispeed);
					break;
				case 2:
					left_slide_circle();
					break;
			}
			
		}
	}
	function right_slide_scroll(){
		// Xác định xem slide có còn hình phía bên phải hay không dựa trên độ dài của stage và container
		var stage_left = Math.abs($('#album-content .slide-stage').position().left);
		var right_remain = stage_width - (display_width + stage_left);
		
		// Nếu có
		if(right_remain > 0 && !$('.slide-stage').is(':animated')){ //Kích hoạt chỉ khi stage ko chuyển động nữa
			$('#album-content .slide-stage').stop().animate({left:"-=" + image_width},anispeed);
		}
		else // Nếu đã chuyển về hình ảnh đầu tiên thì lựa chọn cách thức quay vòng
		{
			switch(circle_method){ //Lựa chọn
				case 1:
					$('#album-content .slide-stage').stop().animate({left:0},anispeed);
					break;
				case 2:
					right_slide_circle();
					break;
			}
		}
	}
	
	$('#album-content .slide-control-prev').click(function(){left_slide_scroll();});
	$('#album-content .slide-control-next').click(function(){right_slide_scroll();});
	
	// ========= Xử lý auto scroll ==================
	
	function start_slide_auto_scroll(){
		play = setInterval(right_slide_scroll,timeinterval);
	}
	
	// Nếu chế độ auto scroll được chọn thì sẽ kích hoạt 
	if(auto_scroll == 1){
		start_slide_auto_scroll(); 
	}

	
})

//end album-content


$(function(){
	
	// ========= Điều chỉnh các thông số cho slideshow =========
	
		// Số lượng hình muốn hiển thị
		// Lượng hình tồn tại trong slide cần nhiều hơn con số này để slide có thể thực hiện chức năng xoay vòng
		var display_image_number2 = 5;
		
		// Lựa chọn cách thức xoay vòng (circle) của slide bằng cách thay đổi circle_method bằng các con số tương ứng
		// Method = 1: Sau khi chạm đến giới hạn slide, slide stage sẽ trượt thẳng về vị trí cuối cùng hoặc đầu tiên
		// Method = 2: Sau khi chạm đến giới hạn slide, slide sẽ được quay vòng qua từng hình
		var circle_method2 = 2;
		
		// Tốc độ dịch chuyển của hình ảnh (đơn vị: milisecond)
		var anispeed2 = 1000;
		
		// Lựa chọn có sử dụng chế độ tự động cuốn hình slide
		// 1 = Kích hoạt, 0 = Không kích hoạt
		var auto_scroll2 = 2;
		
		// Nếu giá trị auto_scroll = 1 thì có thể điều chỉnh giá trị sau để thay đổi thời gian cuộn
		var timeinterval2 = 3600;
		
	
	// ========= Xác định các thông số cơ bản của slideshow =========

	// Xác định số lượng hình của slide, chiều rộng của mỗi hình để tìm ra độ rộng của stage
	var image_count2 = $('#khoacntt .slide-image').length;
	var image_width2 = $('#khoacntt .slide-image').width();
		// Độ rộng của hình ảnh có thể chỉnh sửa bằng css
		// Độ rộng này quan trọng vì nó sẽ ảnh hưởng đến độ rộng của toàn bộ slide, cần được tính toán cẩn thận
	var stage_width2 = image_width2 * image_count2;
	// Xác định chiều rộng của khung hiển thị slide
	var display_width2 = display_image_number2 * image_width2;
	
	// Chỉnh độ dài slide stage tương ứng với số lượng hình cần hiển thị thông qua display_width
	$('#khoacntt .slide-holder').css("width", display_width2 + "px");
	
	// Chỉnh lại độ dài của khối bao quanh các slide-image (slide-stage) cho vừa bằng tổng số khối slide-image
	$('#khoacntt .slide-stage').css("width", stage_width2 + "px");
	

	// ========= Xử lý khi click nút next và prev =========
	
	function left_slide_circle2(){
		$('#khoacntt .slide-image:last-child').addClass('swapthis'); // Xác định hình đang ở vị trí cuối cùng
		$('#khoacntt .swapthis').insertBefore('#khoacntt .slide-image:first'); // Chuyển hình cuối lên trước hình đầu tiên
		$('#khoacntt .slide-stage').css("left",-image_width2 + "px"); // Dịch chuyển tức thời vị trí của stage sang một khoảng bằng 1 slide-image
		$('#khoacntt .slide-stage').stop().animate({left:0},anispeed2); // Thực hiện animation
		$('#khoacntt .swapthis').removeClass('swapthis'); // Reset class cho slide-image vừa chuyển
	}
	function right_slide_circle2(){
		$('#khoacntt .slide-image:first').addClass('swapthis'); // Xác định hình đang ở vị trí cuối cùng
		$('#khoacntt .swapthis').insertAfter('#khoacntt .slide-image:last-child'); // Chuyển hình cuối lên trước hình đầu tiên
		$('#khoacntt .slide-stage').css("left",-(stage_width2 - image_width2 - display_width2) + "px"); // Dịch chuyển tức thời vị trí của stage sang một khoảng bằng 1 slide-image
		$('#khoacntt .slide-stage').stop().animate({left:display_width2 - stage_width2},anispeed2); // Thực hiện animation
		$('#khoacntt .swapthis').removeClass('swapthis'); // Reset class cho slide-image vừa chuyển
	}
	function left_slide_scroll2(){
		// Xác định xem slide có còn hình phía bên trái hay không dựa trên Left của stage
		var stage_left2 = $('#khoacntt .slide-stage').position().left;
		
		// Nếu có
		if(stage_left2 < 0 && !$('#khoacntt .slide-stage').is(':animated')){ //Kích hoạt chỉ khi stage ko chuyển động nữa
			$('#khoacntt .slide-stage').stop().animate({left:"+=" + image_width2},anispeed2);
		}
		else // Nếu đã chuyển về hình ảnh đầu tiên thì lựa chọn cách thức quay vòng
		{	
			switch(circle_method){ //Lựa chọn
				case 1:
					$('#khoacntt .slide-stage').stop().animate({left:display_width2 - stage_width2},anispeed2);
					break;
				case 2:
					left_slide_circle2();
					break;
			}
			
		}
	}
	function right_slide_scroll2(){
		// Xác định xem slide có còn hình phía bên phải hay không dựa trên độ dài của stage và container
		var stage_left2 = Math.abs($('#khoacntt .slide-stage').position().left);
		var right_remain2 = stage_width2 - (display_width2 + stage_left2);
		
		// Nếu có
		if(right_remain2 > 0 && !$('#khoacntt .slide-stage').is(':animated')){ //Kích hoạt chỉ khi stage ko chuyển động nữa
			$('#khoacntt .slide-stage').stop().animate({left:"-=" + image_width2},anispeed2);
		}
		else // Nếu đã chuyển về hình ảnh đầu tiên thì lựa chọn cách thức quay vòng
		{
			switch(circle_method2){ //Lựa chọn
				case 1:
					$('#khoacntt .slide-stage').stop().animate({left:0},anispeed2);
					break;
				case 2:
					right_slide_circle2();
					break;
			}
		}
	}
	
	$('#khoacntt .slide-control-prev').click(function(){left_slide_scroll2();});
	$('#khoacntt .slide-control-next').click(function(){right_slide_scroll2();});
	
	// ========= Xử lý auto scroll ==================
	
	function start_slide_auto_scroll2(){
		play = setInterval(right_slide_scroll2,timeinterval2);
	}
	
	// Nếu chế độ auto scroll được chọn thì sẽ kích hoạt 
	if(auto_scroll2 == 1){
		start_slide_auto_scroll2(); 
	}
	
	// Đưa chuột vào slide và các nút sẽ tạm dừng quá trình auto scroll
	//$("#khoacntt .slide-container,#khoacntt .slide-control-prev,#khoacntt .slide-control-next").hover(function() {
	//	clearInterval(play);
	//}, function(){
	//	start_slide_auto_scroll2();
	//});
	
})
//end khoacntt
$(function(){
	
	// ========= Điều chỉnh các thông số cho slideshow =========
	
		// Số lượng hình muốn hiển thị
		// Lượng hình tồn tại trong slide cần nhiều hơn con số này để slide có thể thực hiện chức năng xoay vòng
		var display_image_number3 = 5;
		
		// Lựa chọn cách thức xoay vòng (circle) của slide bằng cách thay đổi circle_method bằng các con số tương ứng
		// Method = 1: Sau khi chạm đến giới hạn slide, slide stage sẽ trượt thẳng về vị trí cuối cùng hoặc đầu tiên
		// Method = 2: Sau khi chạm đến giới hạn slide, slide sẽ được quay vòng qua từng hình
		var circle_method3 = 2;
		
		// Tốc độ dịch chuyển của hình ảnh (đơn vị: milisecond)
		var anispeed3 = 1000;
		
		// Lựa chọn có sử dụng chế độ tự động cuốn hình slide
		// 1 = Kích hoạt, 0 = Không kích hoạt
		var auto_scroll3 = 2;
		
		// Nếu giá trị auto_scroll = 1 thì có thể điều chỉnh giá trị sau để thay đổi thời gian cuộn
		var timeinterval3 = 3600;
		
	
	// ========= Xác định các thông số cơ bản của slideshow =========

	// Xác định số lượng hình của slide, chiều rộng của mỗi hình để tìm ra độ rộng của stage
	var image_count3 = $('#khoacokhi .slide-image').length;
	var image_width3 = $('#khoacokhi .slide-image').width();
		// Độ rộng của hình ảnh có thể chỉnh sửa bằng css
		// Độ rộng này quan trọng vì nó sẽ ảnh hưởng đến độ rộng của toàn bộ slide, cần được tính toán cẩn thận
	var stage_width3 = image_width3 * image_count3;
	// Xác định chiều rộng của khung hiển thị slide
	var display_width3 = display_image_number3 * image_width3;
	
	// Chỉnh độ dài slide stage tương ứng với số lượng hình cần hiển thị thông qua display_width
	$('#khoacokhi .slide-holder').css("width", display_width3 + "px");
	
	// Chỉnh lại độ dài của khối bao quanh các slide-image (slide-stage) cho vừa bằng tổng số khối slide-image
	$('#khoacokhi .slide-stage').css("width", stage_width3 + "px");
	

	// ========= Xử lý khi click nút next và prev =========
	
	function left_slide_circle3(){
		$('#khoacokhi .slide-image:last-child').addClass('swapthis'); // Xác định hình đang ở vị trí cuối cùng
		$('#khoacokhi .swapthis').insertBefore('#khoacokhi .slide-image:first'); // Chuyển hình cuối lên trước hình đầu tiên
		$('#khoacokhi .slide-stage').css("left",-image_width3 + "px"); // Dịch chuyển tức thời vị trí của stage sang một khoảng bằng 1 slide-image
		$('#khoacokhi .slide-stage').stop().animate({left:0},anispeed3); // Thực hiện animation
		$('#khoacokhi .swapthis').removeClass('swapthis'); // Reset class cho slide-image vừa chuyển
	}
	function right_slide_circle3(){
		$('#khoacokhi .slide-image:first').addClass('swapthis'); // Xác định hình đang ở vị trí cuối cùng
		$('#khoacokhi .swapthis').insertAfter('#khoacokhi .slide-image:last-child'); // Chuyển hình cuối lên trước hình đầu tiên
		$('#khoacokhi .slide-stage').css("left",-(stage_width3 - image_width3 - display_width3) + "px"); // Dịch chuyển tức thời vị trí của stage sang một khoảng bằng 1 slide-image
		$('#khoacokhi .slide-stage').stop().animate({left:display_width3 - stage_width3},anispeed3); // Thực hiện animation
		$('#khoacokhi .swapthis').removeClass('swapthis'); // Reset class cho slide-image vừa chuyển
	}
	function left_slide_scroll3(){
		// Xác định xem slide có còn hình phía bên trái hay không dựa trên Left của stage
		var stage_left3 = $('#khoacokhi .slide-stage').position().left;
		
		// Nếu có
		if(stage_left3 < 0 && !$('#khoacokhi .slide-stage').is(':animated')){ //Kích hoạt chỉ khi stage ko chuyển động nữa
			$('#khoacokhi .slide-stage').stop().animate({left:"+=" + image_width3},anispeed3);
		}
		else // Nếu đã chuyển về hình ảnh đầu tiên thì lựa chọn cách thức quay vòng
		{	
			switch(circle_method){ //Lựa chọn
				case 1:
					$('#khoacokhi .slide-stage').stop().animate({left:display_width3 - stage_width3},anispeed3);
					break;
				case 2:
					left_slide_circle3();
					break;
			}
			
		}
	}
	function right_slide_scroll2(){
		// Xác định xem slide có còn hình phía bên phải hay không dựa trên độ dài của stage và container
		var stage_left3 = Math.abs($('#khoacokhi .slide-stage').position().left);
		var right_remain2 = stage_width3 - (display_width3 + stage_left3);
		
		// Nếu có
		if(right_remain2 > 0 && !$('#khoacokhi .slide-stage').is(':animated')){ //Kích hoạt chỉ khi stage ko chuyển động nữa
			$('#khoacokhi .slide-stage').stop().animate({left:"-=" + image_width3},anispeed3);
		}
		else // Nếu đã chuyển về hình ảnh đầu tiên thì lựa chọn cách thức quay vòng
		{
			switch(circle_method3){ //Lựa chọn
				case 1:
					$('#khoacokhi .slide-stage').stop().animate({left:0},anispeed3);
					break;
				case 2:
					right_slide_circle3();
					break;
			}
		}
	}
	
	$('#khoacokhi .slide-control-prev').click(function(){left_slide_scroll3();});
	$('#khoacokhi .slide-control-next').click(function(){right_slide_scroll2();});
	
	// ========= Xử lý auto scroll ==================
	
	function start_slide_auto_scroll3(){
		play = setInterval(right_slide_scroll2,timeinterval3);
	}
	
	// Nếu chế độ auto scroll được chọn thì sẽ kích hoạt 
	if(auto_scroll3 == 1){
		start_slide_auto_scroll3(); 
	}
	
	
})

/*end khoacokhi*/

$(function(){
	
	// ========= Điều chỉnh các thông số cho slideshow =========
	
		// Số lượng hình muốn hiển thị
		// Lượng hình tồn tại trong slide cần nhiều hơn con số này để slide có thể thực hiện chức năng xoay vòng
		var display_image_number4 = 5;
		
		// Lựa chọn cách thức xoay vòng (circle) của slide bằng cách thay đổi circle_method bằng các con số tương ứng
		// Method = 1: Sau khi chạm đến giới hạn slide, slide stage sẽ trượt thẳng về vị trí cuối cùng hoặc đầu tiên
		// Method = 2: Sau khi chạm đến giới hạn slide, slide sẽ được quay vòng qua từng hình
		var circle_method4 = 2;
		
		// Tốc độ dịch chuyển của hình ảnh (đơn vị: milisecond)
		var anispeed4 = 1000;
		
		// Lựa chọn có sử dụng chế độ tự động cuốn hình slide
		// 1 = Kích hoạt, 0 = Không kích hoạt
		var auto_scroll4 = 2;
		
		// Nếu giá trị auto_scroll = 1 thì có thể điều chỉnh giá trị sau để thay đổi thời gian cuộn
		var timeinterval4 = 3600;
		
	
	// ========= Xác định các thông số cơ bản của slideshow =========

	// Xác định số lượng hình của slide, chiều rộng của mỗi hình để tìm ra độ rộng của stage
	var image_count4 = $('#khoakt .slide-image').length;
	var image_width4 = $('#khoakt .slide-image').width();
		// Độ rộng của hình ảnh có thể chỉnh sửa bằng css
		// Độ rộng này quan trọng vì nó sẽ ảnh hưởng đến độ rộng của toàn bộ slide, cần được tính toán cẩn thận
	var stage_width4 = image_width4 * image_count4;
	// Xác định chiều rộng của khung hiển thị slide
	var display_width4 = display_image_number4 * image_width4;
	
	// Chỉnh độ dài slide stage tương ứng với số lượng hình cần hiển thị thông qua display_width
	$('#khoakt .slide-holder').css("width", display_width4 + "px");
	
	// Chỉnh lại độ dài của khối bao quanh các slide-image (slide-stage) cho vừa bằng tổng số khối slide-image
	$('#khoakt .slide-stage').css("width", stage_width4 + "px");
	

	// ========= Xử lý khi click nút next và prev =========
	
	function left_slide_circle4(){
		$('#khoakt .slide-image:last-child').addClass('swapthis'); // Xác định hình đang ở vị trí cuối cùng
		$('#khoakt .swapthis').insertBefore('#khoakt .slide-image:first'); // Chuyển hình cuối lên trước hình đầu tiên
		$('#khoakt .slide-stage').css("left",-image_width4 + "px"); // Dịch chuyển tức thời vị trí của stage sang một khoảng bằng 1 slide-image
		$('#khoakt .slide-stage').stop().animate({left:0},anispeed4); // Thực hiện animation
		$('#khoakt .swapthis').removeClass('swapthis'); // Reset class cho slide-image vừa chuyển
	}
	function right_slide_circle4(){
		$('#khoakt .slide-image:first').addClass('swapthis'); // Xác định hình đang ở vị trí cuối cùng
		$('#khoakt .swapthis').insertAfter('#khoakt .slide-image:last-child'); // Chuyển hình cuối lên trước hình đầu tiên
		$('#khoakt .slide-stage').css("left",-(stage_width4 - image_width4 - display_width4) + "px"); // Dịch chuyển tức thời vị trí của stage sang một khoảng bằng 1 slide-image
		$('#khoakt .slide-stage').stop().animate({left:display_width4 - stage_width4},anispeed4); // Thực hiện animation
		$('#khoakt .swapthis').removeClass('swapthis'); // Reset class cho slide-image vừa chuyển
	}
	function left_slide_scroll4(){
		// Xác định xem slide có còn hình phía bên trái hay không dựa trên Left của stage
		var stage_left4 = $('#khoakt .slide-stage').position().left;
		
		// Nếu có
		if(stage_left4 < 0 && !$('#khoakt .slide-stage').is(':animated')){ //Kích hoạt chỉ khi stage ko chuyển động nữa
			$('#khoakt .slide-stage').stop().animate({left:"+=" + image_width4},anispeed4);
		}
		else // Nếu đã chuyển về hình ảnh đầu tiên thì lựa chọn cách thức quay vòng
		{	
			switch(circle_method){ //Lựa chọn
				case 1:
					$('#khoakt .slide-stage').stop().animate({left:display_width4 - stage_width4},anispeed4);
					break;
				case 2:
					left_slide_circle4();
					break;
			}
			
		}
	}
	function right_slide_scroll4(){
		// Xác định xem slide có còn hình phía bên phải hay không dựa trên độ dài của stage và container
		var stage_left4 = Math.abs($('#khoakt .slide-stage').position().left);
		var right_remain4 = stage_width4 - (display_width4 + stage_left4);
		
		// Nếu có
		if(right_remain4 > 0 && !$('#khoakt .slide-stage').is(':animated')){ //Kích hoạt chỉ khi stage ko chuyển động nữa
			$('#khoakt .slide-stage').stop().animate({left:"-=" + image_width4},anispeed4);
		}
		else // Nếu đã chuyển về hình ảnh đầu tiên thì lựa chọn cách thức quay vòng
		{
			switch(circle_method4){ //Lựa chọn
				case 1:
					$('#khoakt .slide-stage').stop().animate({left:0},anispeed4);
					break;
				case 2:
					right_slide_circle4();
					break;
			}
		}
	}
	
	$('#khoakt .slide-control-prev').click(function(){left_slide_scroll4();});
	$('#khoakt .slide-control-next').click(function(){right_slide_scroll4();});
	
	// ========= Xử lý auto scroll ==================
	
	function start_slide_auto_scroll4(){
		play = setInterval(right_slide_scroll4,timeinterval4);
	}
	
	// Nếu chế độ auto scroll được chọn thì sẽ kích hoạt 
	if(auto_scroll4 == 1){
		start_slide_auto_scroll4(); 
	}
	
	
})
//end-khoakt

$(function(){
	
	// ========= Điều chỉnh các thông số cho slideshow =========
	
		// Số lượng hình muốn hiển thị
		// Lượng hình tồn tại trong slide cần nhiều hơn con số này để slide có thể thực hiện chức năng xoay vòng
		var display_image_number5 = 5;
		
		// Lựa chọn cách thức xoay vòng (circle) của slide bằng cách thay đổi circle_method bằng các con số tương ứng
		// Method = 1: Sau khi chạm đến giới hạn slide, slide stage sẽ trượt thẳng về vị trí cuối cùng hoặc đầu tiên
		// Method = 2: Sau khi chạm đến giới hạn slide, slide sẽ được quay vòng qua từng hình
		var circle_method5 = 2;
		
		// Tốc độ dịch chuyển của hình ảnh (đơn vị: milisecond)
		var anispeed5 = 1000;
		
		// Lựa chọn có sử dụng chế độ tự động cuốn hình slide
		// 1 = Kích hoạt, 0 = Không kích hoạt
		var auto_scroll5 = 1;
		
		// Nếu giá trị auto_scroll = 1 thì có thể điều chỉnh giá trị sau để thay đổi thời gian cuộn
		var timeinterval5 = 3600;
		
	
	// ========= Xác định các thông số cơ bản của slideshow =========

	// Xác định số lượng hình của slide, chiều rộng của mỗi hình để tìm ra độ rộng của stage
	var image_count5 = $('#view-news .slide-image').length;
	var image_height5 = $('#view-news .slide-image').height();
		// Độ rộng của hình ảnh có thể chỉnh sửa bằng css
		// Độ rộng này quan trọng vì nó sẽ ảnh hưởng đến độ rộng của toàn bộ slide, cần được tính toán cẩn thận
	var stage_height5 = image_height5 * image_count5;
	// Xác định chiều rộng của khung hiển thị slide
	var display_height5 = (display_image_number5 * image_height5);
	
	// Chỉnh độ dài slide stage tương ứng với số lượng hình cần hiển thị thông qua display_height
	$('#view-news .slide-holder').css("height", display_height5 + "px");
	
	// Chỉnh lại độ dài của khối bao quanh các slide-image (slide-stage) cho vừa bằng tổng số khối slide-image
	$('#view-news .slide-stage').css("height", stage_height5 + "px");
	

	// ========= Xử lý khi click nút next và prev =========
	
	function top_slide_circle5(){
		$('#view-news .slide-image:last-child').addClass('swapthis'); // Xác định hình đang ở vị trí cuối cùng
		$('#view-news .swapthis').insertBefore('#view-news .slide-image:first'); // Chuyển hình cuối lên trước hình đầu tiên
		$('#view-news .slide-stage').css("top",-image_height5 + "px"); // Dịch chuyển tức thời vị trí của stage sang một khoảng bằng 1 slide-image
		$('#view-news .slide-stage').stop().animate({top:0},anispeed5); // Thực hiện animation
		$('#view-news .swapthis').removeClass('swapthis'); // Reset class cho slide-image vừa chuyển
	}
	function bottom_slide_circle5(){
		$('#view-news .slide-image:first').addClass('swapthis'); // Xác định hình đang ở vị trí cuối cùng
		$('#view-news .swapthis').insertAfter('#view-news .slide-image:last-child'); // Chuyển hình cuối lên trước hình đầu tiên
		$('#view-news .slide-stage').css("top",-(stage_height5 - image_height5 - display_height5) + "px"); // Dịch chuyển tức thời vị trí của stage sang một khoảng bằng 1 slide-image
		$('#view-news .slide-stage').stop().animate({top:display_height5 - stage_height5},anispeed5); // Thực hiện animation
		$('#view-news .swapthis').removeClass('swapthis'); // Reset class cho slide-image vừa chuyển
	}
	function top_slide_scroll5(){
		// Xác định xem slide có còn hình phía bên trái hay không dựa trên top của stage
		var stage_top5 = $('#view-news .slide-stage').position().top;
		
		// Nếu có
		if(stage_top5 < 0 && !$('#view-news .slide-stage').is(':animated')){ //Kích hoạt chỉ khi stage ko chuyển động nữa
			$('#view-news .slide-stage').stop().animate({top:"+=" + image_height5},anispeed5);
		}
		else // Nếu đã chuyển về hình ảnh đầu tiên thì lựa chọn cách thức quay vòng
		{	
			switch(circle_method){ //Lựa chọn
				case 1:
					$('#view-news .slide-stage').stop().animate({top:display_height5 - stage_height5},anispeed5);
					break;
				case 2:
					top_slide_circle5();
					break;
			}
			
		}
	}
	function bottom_slide_scroll5(){
		// Xác định xem slide có còn hình phía bên phải hay không dựa trên độ dài của stage và container
		var stage_top5 = Math.abs($('#view-news .slide-stage').position().top);
		var bottom_remain5 = stage_height5 - (display_height5 + stage_top5);
		
		// Nếu có
		if(bottom_remain5 > 0 && !$('#view-news .slide-stage').is(':animated')){ //Kích hoạt chỉ khi stage ko chuyển động nữa
			$('#view-news .slide-stage').stop().animate({top:"-=" + image_height5},anispeed5);
		}
		else // Nếu đã chuyển về hình ảnh đầu tiên thì lựa chọn cách thức quay vòng
		{
			switch(circle_method5){ //Lựa chọn
				case 1:
					$('#view-news .slide-stage').stop().animate({top:0},anispeed5);
					break;
				case 2:
					bottom_slide_circle5();
					break;
			}
		}
	}
	
	$('#view-news .slide-control-prev').click(function(){top_slide_scroll5();});
	$('#view-news .slide-control-next').click(function(){bottom_slide_scroll5();});
	
	// ========= Xử lý auto scroll ==================
	
	function start_slide_auto_scroll5(){
		play = setInterval(bottom_slide_scroll5,timeinterval5);
	}
	
	// Nếu chế độ auto scroll được chọn thì sẽ kích hoạt 
	if(auto_scroll5 == 1){
		start_slide_auto_scroll5(); 
	}

	
	
	
})
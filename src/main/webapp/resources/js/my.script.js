
	$(document).ready(function () {
		$(".row").hide();
	});

	function replaceRed(str,index){
		return str.substr(0,index)+str.substr(index).replace(/\-\w+\..+%/,'<strong class="red-cot">$&</strong>');
	}

	function replaceGreen(str,index){
		return str.substr(0,index)+str.substr(index).replace(/\+\w+\..+%/,'<strong class="green-cot">$&</strong>');
	}


	function get_parse() {

		$.getJSON('/parser', function(data) {
			$.each(data, function(key, val) {
				if( val.indexOf('+') > 0 ){
					$('.row').append(
						'<div class="col-xs pull-left block">' +
						'<div class="col-xs pull-left white-cot">' + key + '</div>' +
						'<div class="col-xs pull-left">&nbsp;' + replaceGreen(val, 5) + '</div>' +
						'</div>'
					);
				} else if( val.indexOf('-') > 0){
					$('.row').append(
						'<div class="col-xs pull-left block">' +
						'<div class="col-xs pull-left white-cot">' + key + '</div>' +
						'<div class="col-xs pull-left">&nbsp;' + replaceRed(val, 5) + '</div>' +
						'</div>'
					);

				} else {
					$('.row').append(
						'<div class="col-xs pull-left block">' +
						'<div class="col-xs pull-left white-cot">' + key + '</div>' +
						'<div class="col-xs pull-left">&nbsp;' + val + '</div>' +
						'</div>'
					);
				}

			});
			$(".row").show();
			$("body").faLoading(false);
		});

		$("body").faLoading({
			"type" : "add",
			"icon" : "fa-refresh",
			"status" : 'loading',
			"text" : false,
			"title" : "Пожалуйста подождите..."
		});

	}



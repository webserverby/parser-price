### Парсер котировок Oil & Gas с сайта *http://www.msenergyservices.com*  @author Artem Faenko

Т.к. котировки подгружаются скриптами, то пришлось использовать консольный виртуальный браузер.
Сначала для парсинга был применен - *PhantomJS*. Время загрузки данных составляло 5 секунд.

Но из-за того, что к нему еще нужно было подключать библиотеку для определённой версии ОС, которая весит 18 Мб, то был применен более легковесный аналог - *HtmlUnitDriver*.
Но скорость загрузки увеличилась до 15-20 секунд.
 
**Скриншоты:** 

![CC0](https://github.com/webserverby/parser-price/blob/master/screenshots/glav_1.png)

![CC0](https://github.com/webserverby/parser-price/blob/master/screenshots/glav_2.png)

![CC0](https://github.com/webserverby/parser-price/blob/master/screenshots/glav_3.png)

С сервера получаем json ответ *{"US Rig Count:":"51.90","WTI Crude Oil":"51.90 +1.93%","Brent Crude Oil":"55.21 +2.16%","Natural Gas"
:"3.41 -0.56%","P:":"936.442.2500","F:":"936.442.2599"}* 

**Скрипт:** 
*$(document).ready(function () {
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
*

### Парсер котировок Oil & Gas с сайта http://www.msenergyservices.com  @author Artem Faenko

**<a href="https://parser-price.herokuapp.com/" target=_blank>Демо разрабатываемого приложения</a>**

**Применил:** 
- Back-end - Spring MVC
- Front-end - JS, jQuery(ajax), JSP, CSS, сборщик Gradle
- Library - Selenium(HtmlUnitDriver, PhantomJS), Jsoup, Jackson(json)

Т.к. котировки подгружаются скриптами, то пришлось использовать консольный виртуальный браузер.
Сначала для парсинга был применен - *PhantomJS*. Время загрузки данных составляло 3-5 секунд.

Но из-за того, что к нему еще нужно было подключать библиотеку для определённой версии ОС, которая весит 18 Мб, то был применен более легковесный аналог - *HtmlUnitDriver*.
Но скорость загрузки увеличилась до 12-15 секунд.
 
**Скриншоты:** 

![CC0](https://github.com/webserverby/parser-price/blob/master/screenshots/glav_1.png)

![CC0](https://github.com/webserverby/parser-price/blob/master/screenshots/glav_2.png)

![CC0](https://github.com/webserverby/parser-price/blob/master/screenshots/glav_3.png)

С сервера получаем json ответ *{"US Rig Count:":"51.90","WTI Crude Oil":"51.90 +1.93%","Brent Crude Oil":"55.21 +2.16%","Natural Gas"
:"3.41 -0.56%","P:":"936.442.2500","F:":"936.442.2599"}* 

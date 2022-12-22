# ServerLogAnalyzerProject

<b> Please mke sure to enter command "proceed", "Proceed", "PROCEED" and hit enter when input is pasted/inserted line by line! </b>

The application takes input in the following format:

Date  Time  IP  Method  Path  Response  Size  Time(ms)

<b> Example valid input: </b>

2022/05/19 02:49:12 127.0.0.1 GET / 200 1314 65   
2022/05/19 02:49:35 127.0.0.1 GET /index.html 200 2218 121  
2022/05/19 03:01:06 127.0.0.1 GET /images/sponsered.gif 304 171344 491  
2022/05/19 03:52:36 127.0.0.1 GET /search.php 200 12085 154  
2022/05/19 04:17:03 127.0.0.1 GET /admin/style.css 200 615 98  
2022/05/19 05:04:54 127.0.0.1 GET /favicon.ico 404 - 1808  
2022/05/19 05:38:07 127.0.0.1 GET /js/ads.js 200 19144 161  
proceed  

<b> Output: </b>

The percentage of requests with status code different than 200 is: 28  
Slowest requests are:   
RequestLog{date='2022/05/19', time='05:04:54', ipAddress='127.0.0.1', httpMethod='GET', path='/favicon.ico', response=404, size=0, timeMs=1808}  
RequestLog{date='2022/05/19', time='05:04:54', ipAddress='127.0.0.1', httpMethod='GET', path='/favicon.ico', response=404, size=0, timeMs=1808}  
RequestLog{date='2022/05/19', time='03:01:06', ipAddress='127.0.0.1', httpMethod='GET', path='/images/sponsered.gif', response=304, size=171344, timeMs=491}  

<b> Example invalid input: </b>

19 02:49:12 127.0.0.1 GET / 200 1314 65  
2022/05/19 02:49:35 127.0.0.1 GET /index.html 200 2218 121  
2022/05/19 03:01:06 127.0.0.1 GET /images/sponsered.gif 304 171344 491  
2022/05/19 03:52:36 127.0.0.1 GET /search.php 200 12085 154  
2022/05/19 04:17:03 127.0.0.1 GET /admin/style.css 200 615 98  
2022/05/19 05:04:54 127.0.0.1 GET /favicon.ico 404 - 1808  
2022/05/19 05:38:07 127.0.0.1 GET /js/ads.js 200 19144 161  
2022/05/19 02:49:12 127.0.0.1 GET / 200 1314 65  
2022/05/19 02:49:35 127.0.0.1 GET /index.html 200 2218 121  
2022/05/19 03:01:06 127.0.0.1 GET /images/sponsered.gif 304 171344 491  
2022/05/19 03:52:36 127.0.0.1 GET /search.php 200 12085 154  
2022/05/19 04:17:03 127.0.0.1 GET /admin/style.css 200 615 98  
2022/05/19 05:04:54 127.0.0.1 GET /favicon.ico 404 - 1808  
2022/05/19 05:38:07 127.0.0.1 GET /js/ads.js 200 19144 161  
proceed  

<b> Output: </b>

Invalid input. Date should be in format yyyy-mm-dd  

<b> Example invalid input: </b>

2022/05/19  
proceed  

<b> Output: </b>

Incomplete input. Please make sure you have entered:   
Date  Time  IP  Method  Path  Response  Size  Time(ms)  

<b> Example invalid input: </b>

-1  
proceed  

<b> Output: </b>

Incomplete input. Please make sure you have entered:   
Date  Time  IP  Method  Path  Response  Size  Time(ms)  

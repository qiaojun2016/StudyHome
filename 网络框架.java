网络框架 发出请求得到json 字符串。
how to implement it ？
1、 选择一个合适的请求类库，（OkHttp、Volley，Retrofit）
2、 写接口回调方法。
3、 基本的请求参数，超时时间、编码、等。
4、 返回的肯定是一个Json 字符串，你，你可以返回一个Json对象。

于是选择 使用OkHttp 作为网络请求库
我很是纠结啊 ，怎么开始，的那个了去。
OkHttpClient 

Json字符串的解析
FastJson 常用方法
public static final Object parse(String text); //把JSON文本parse为JSONObject或者JSONArray    
  
public static final JSONObject parseObject(String text)； //把JSON文本parse成JSONObject  
  
public static final  T parseObject(String text, Class clazz); // 把JSON文本parse为JavaBean  
  
public static final JSONArray parseArray(String text); //把JSON文本parse成JSONArray  
  
public static final  List parseArray(String text, Class clazz); //把JSON文本parse成JavaBean集合  
  
public static final String toJSONString(Object object); //将JavaBean序列化为JSON文本  
  
public static final String toJSONString(Object object, boolean prettyFormat); //将JavaBean序列化为带格式的JSON文本  
  
public static final Object toJSON(Object javaObject); //将JavaBean转换为JSONObject或者JSONArray


Http基础
1、如何向服务器传递参数
	用GET方法，可以加在url 的后面
	使用POST方法，添加在body里面
	POST和GET方法都可以把参数放到HEADER(首部)里面
Request 请求报文
	请求行(START-LINE)
	首部(HEADER)
	主体(可选)

Response 响应报文
	响应行
	首部(HEADER)
	主体(可选)

okHttp3的使用
OkHttpClient.newBuilder() 方法的作用是什么？
可以看看newBuilder的源码 return new Builder(this);
写一个请求框架注意的问题：
1、分清楚是异步请求还是同步请求。
	如果是异步请求，那么保证回调在UI线程进行。
2、做请求之前，要判断当前的网络状态。
3、如果请求结果是一个JSON 串，可以考虑利用泛型参数，直接做出解析。

Call 接口是什么？
Call 是一个将要准备执行的请求，一个Call 是可以被Canceled的
这个Call 就代表了一个 request/response 的流，不能执行两次。
Call.execute() 立即执行，会阻塞，直到调用完成。
Call.enqueue(Callback) 加入到线程调度中，相当于异步执行请求。

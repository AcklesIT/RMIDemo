rmi的实现虽然比较简单,但是看起来很不舒服,
首先接口HelloService的继承Remote
其次实现类还得继承UnicastRemoteObject
同时定义的接口方法还得抛出异常RemoteException

使用场景:内网服务器与服务器之间的相互调用
性能应该还行,毕竟是内网之间的调用

访问服务提供者的时候需要将Remote强转为访问的对象,当然这个可以提供一个通用的强转方法,使难看的强转变得透明

增加了一个RmiName注解,注:只是加在了提供服务的接口上,使用的时候需注意


rmi与rpc
rmi只支持java,但是可以直接返回一个对象,采用TCP/IP协议
rpc支持多语言,但是不能直接返回一个对象,采用HTTP协议
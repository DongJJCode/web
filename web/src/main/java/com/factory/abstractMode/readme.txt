抽象工厂模式的优点：
    抽象工厂模式除了具有工厂模式的优点外，最主要的优点就是可以在类的内部对产品族进行约束。
    所谓的产品族，一般或多或少的都存在一定的关联，抽象工厂模式可以在类内部对产品族的关联关系进行
    定义和描述，而不必专门引入一个新的类进行管理。


抽象工厂模式的缺点：
    产品族的扩展将是一件十分费力的事情，加入产品族中需要增加一个新的产品，则几乎所有的工厂类都需要进行修改。
    所以使用抽象工厂模式时，对产品等级结构的划分非常重要。

适用场景
    当需要创建的对象是一系列相互关联或相互依赖的产品族时，可以使用抽象工厂模式。
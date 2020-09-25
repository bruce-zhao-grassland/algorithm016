### Java中HashMap的插入、查询

#### 一、插入put(K k, V v)

1.  HashMap创建时，没有初始化**table**数组，首次插入发现table为null，调用resize方法，初始化table。
2. k为非null时，根据hash值计算出bin的位置，查看table[bin]是否有元素，没有就使用k,v创建一个Node，放入桶中
3. table[bin]上元素p，判断p.key是否和k相等（同一个元素，或者equals），若是，更新其值，返回旧值
4. 判断p是TreeNode的实例，在树中查找节点与k相同的，若找不到，则插入一个TreeNode节点，若找到则更新其值，返回旧值。
5. p是链表的head节点，查找链表，找不到相符的p.key，则新建Node，放入链表末尾。判断链表长度是否达到8，达到，则再判断table长度是否小于64，若小于，则resize()；若不小，则treeifyBin()，把链表转换成树结构，查找速度加快。
6. 综上，put操作，会插入k,v映射，返回旧的value值（若存在k），或者null（不存在k）

#### 二、查询get(Object key)

1. 计算key的hash值，key为null，返回0，否则计算key的hash值，int h = key.hashcode()，return h^(h>>>16)
2. 根据hash值，计算桶的位置，判断桶上有无元素，无元素返回null
3. 有元素，判断是否就是key，是就返回value
4. 首元素不是，则接下来分是否是TreeNode和Node
5. TreeNode，在树中查找一个TreeNode的key与入参key相同的，返回
6. Node，在链表中查找Node的key与入参key相同的，返回
7. key的相同的表达式是 p.key == key,或者 key!=null, key.equals(p.key)
8. 得到value值，或者null
9. 注意，得到null，不能表明HashMap中不包含key的映射，要直到是否包含，请用containsKey(Object key)

​	
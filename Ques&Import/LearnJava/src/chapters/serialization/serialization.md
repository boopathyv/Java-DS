# https://www.javatpoint.com/serialization-in-java
transient
static   
-- both wont get serialized

all the object associated in an object shud be serialized.

 ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));
 in.readObject();
 in.close();
 
 ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("f.txt"));
 out.writeObject(someObj);
 out.close();
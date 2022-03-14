package 内部类;
//一个类实现内部接口
public class TestInnerInterface implements OuterInterface.InnerInterface{
	@Override
	public void innnerMethod() {
		System.out.println("-- 实现内部类接口方法 --");
	}
}

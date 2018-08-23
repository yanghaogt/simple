package DepartMent;


import java.util.List;

public class Dept {

	private int id;
	private String name;
	private Dept parent;
	private List<Dept> children;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Dept getParent() {
		return parent;
	}
	public void setParent(Dept parent) {
		this.parent = parent;
	}
	public List<Dept> getChildren() {
		return children;
	}
	public void setChildren(List<Dept> children) {
		this.children = children;
	}
}

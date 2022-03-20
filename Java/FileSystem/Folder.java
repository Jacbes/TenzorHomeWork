import java.util.ArrayList;
import java.util.List;

public class Folder extends BaseFileSystemNode {

    private final List<BaseFileSystemNode> childs = new ArrayList<>();

    public Folder(String inName, BaseFileSystemNode inParent, BaseFileSystemNode... inNodes) {
        setName(inName);
        if (inParent instanceof Folder) {
            setParent(inParent);
            Folder folderParent = (Folder) inParent;
            folderParent.getChilds().add(this);
        } else {
            setParent(null);
        }
        for (BaseFileSystemNode node : inNodes) {
            childs.add(node);
            if (node instanceof Folder) {
                Folder parentNode = (Folder) node.getParent();
                parentNode.getChilds().remove(node);
            }
            node.setParent(this);
        }
    }

    @Override
    public String getName() {
        return name + "/";
    }

    public List<BaseFileSystemNode> getChilds() {
        return childs;
    }

}

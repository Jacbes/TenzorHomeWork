import java.util.ArrayList;
import java.util.List;

public class Folder extends AbstractFileSystemNode {

    private final List<AbstractFileSystemNode> childs = new ArrayList<>();

    public Folder(String inName, AbstractFileSystemNode inParent, AbstractFileSystemNode... inNodes) {
        setName(inName);
        if (inParent instanceof Folder) {
            setParent(inParent);
            Folder folderParent = (Folder) inParent;
            folderParent.getChilds().add(this);
        } else {
            setParent(null);
        }
        for (AbstractFileSystemNode node : inNodes) {
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

    public List<AbstractFileSystemNode> getChilds() {
        return childs;
    }

}


public class File extends AbstractFileSystemNode {

    public File(String inName, AbstractFileSystemNode inParent) {
        setName(inName);
        if (inParent instanceof Folder) {
            setParent(inParent);
            Folder folderParent = (Folder) inParent;
            folderParent.getChilds().add(this);
        } else {
            setParent(null);
        }
    }

    public String getExtension() {
        int indexOfExtension = getName().indexOf('.');
        return getName().substring(indexOfExtension + 1);
    }

}

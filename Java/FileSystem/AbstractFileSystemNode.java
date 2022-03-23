
abstract class AbstractFileSystemNode implements FileSystemNode {

    protected AbstractFileSystemNode parent;
    protected String name;

    @Override
    public final FileSystemNode getParent() {
        return parent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public final String getPath() {
        String resultPath = "";
        FileSystemNode parentGoUp = this;

        while (parentGoUp != null) {
            resultPath = parentGoUp.getName().concat(resultPath);
            parentGoUp = parentGoUp.getParent();
        }

        return resultPath;
    }

    public void setParent(AbstractFileSystemNode inParent) {
        this.parent = inParent;
    }

    public void setName(String inName) {
        this.name = inName;
    }

}

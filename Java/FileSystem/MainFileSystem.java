
public class MainFileSystem {

    public static void main(String[] args) {
        Folder root = new Folder("root", null);
        Folder subDir1 = new Folder("subDir1", root);
        File file = new File("Hello.c", null);
        File file1 = new File("foo.b", null);
        Folder subDir2 = new Folder("subDir2", root, file, file1, subDir1);
        File file2 = new File("goo.g", subDir1);

        System.out.println("root:");
        root.getChilds()
                .forEach(baseFileSystemNode ->
                        System.out.println("\t" + baseFileSystemNode.getName())
                );

        System.out.println("subDir2:");
        subDir2.getChilds()
                .forEach(baseFileSystemNode ->
                        System.out.println("\t" + baseFileSystemNode.getName())
                );

        System.out.println("subDir1:");
        subDir1.getChilds()
                .forEach(baseFileSystemNode ->
                        System.out.println("\t" + baseFileSystemNode.getName())
                );

        System.out.println("Path to goo.g: " + file2.getPath());
        System.out.println(subDir2.getChilds().get(0).getName()
                + " extension: " + ((File) subDir2.getChilds().get(0)).getExtension());
    }

}

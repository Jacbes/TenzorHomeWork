fun main(args: Array<String>) {
    val root = Folder("root", null)
    val subDir1 = Folder("subDir1", root)
    val file = File("Hello.c", null)
    val file1 = File("foo.b", null)
    val subDir2 = Folder("subdir2", root, file, file1, subDir1)
    val file2 = File("goo.g", subDir1)

    println("root:")
    root.childs.forEach {
        println("\t${it.name}")
    }
    println("subDir2:")
    subDir2.childs.forEach {
        println("\t${it.name}")
    }
    println("subDir1:")
    subDir1.childs.forEach {
        println("\t${it.name}")
    }

    println("Path to goo.g: ${file2.getPath()}")
    println("${file.name} extension ${file.getExtension()}")
}

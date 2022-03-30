interface FileSystemNode {
    val parent: AbstractFileSystemNode?
    val name: String

    fun getPath(): String
}

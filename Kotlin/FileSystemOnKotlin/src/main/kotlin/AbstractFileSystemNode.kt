abstract class AbstractFileSystemNode : FileSystemNode {
    override var parent: AbstractFileSystemNode? = null
    override var name: String = ""

    final override fun getPath(): String {
        var parentGoUp = this as AbstractFileSystemNode?
        val listOfNames = mutableListOf<String>()

        while (parentGoUp != null) {
            listOfNames.add(parentGoUp.name)
            parentGoUp = parentGoUp.parent
        }

        return listOfNames.reversed().joinToString(separator = "")
    }
}

class File() : AbstractFileSystemNode() {
    constructor(inName: String, inParent: AbstractFileSystemNode?) : this() {
        name = inName
        if (inParent is Folder) {
            parent = inParent
            inParent.childs.add(this)
        } else {
            parent = inParent
        }
    }

    fun getExtension(): String {
        return name.substring(name.lastIndexOf('.'))
    }
}

package jp.co.cyberagent.kyotohack2018.f.data

data class Content(
        val id : Long,
        val company : Company,
        val author : String,
        val tag : List<Tag>,
        val title : String,
        val description : String,
        val thumbnail : String,// Url
        val isBookMarked : Boolean,
        val createAt : Long
)
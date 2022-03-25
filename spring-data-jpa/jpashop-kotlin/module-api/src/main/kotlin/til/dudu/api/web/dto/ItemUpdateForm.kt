package til.dudu.api.web.dto

data class ItemUpdateForm(
   val id: Long,
   val name: String,
   val price: Int,
   val stockQuantity: Int
)
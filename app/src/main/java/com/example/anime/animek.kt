package com.example.anime

import com.google.gson.annotations.SerializedName

data class User(

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)

data class Images(

	@field:SerializedName("jpg")
	val jpg: Jpg? = null,

	@field:SerializedName("webp")
	val webp: Webp? = null
)

data class Animek(

	@field:SerializedName("pagination")
	val pagination: Pagination? = null,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null
)

data class Webp(

	@field:SerializedName("large_image_url")
	val largeImageUrl: String? = null,

	@field:SerializedName("small_image_url")
	val smallImageUrl: String? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null
)

data class EntryItem(

	@field:SerializedName("images")
	val images: Images? = null,

	@field:SerializedName("mal_id")
	val malId: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Jpg(

	@field:SerializedName("large_image_url")
	val largeImageUrl: String? = null,

	@field:SerializedName("small_image_url")
	val smallImageUrl: String? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null
)

data class DataItem(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("entry")
	val entry: List<EntryItem?>? = null,

	@field:SerializedName("mal_id")
	val malId: String? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("content")
	val content: String? = null
)

data class Pagination(

	@field:SerializedName("has_next_page")
	val hasNextPage: Boolean? = null,

	@field:SerializedName("last_visible_page")
	val lastVisiblePage: Int? = null
)
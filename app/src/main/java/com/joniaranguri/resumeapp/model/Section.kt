package com.joniaranguri.resumeapp.model

open class Section<C>(val description: String = "", val sectionList: List<C>)
open class SingleSection<C>(val description: String = "", val data: C)
//package com.example.compose.jetchat.data.domain

//import com.example.compose.jetchat.data.local.dao.CategoryDao

//class CategoryLevelResolver(
//    private val categoryDao: CategoryDao
//) {

  //  suspend fun resolveLevel(parentId: Long?): Int {
  //     if (parentId == null) return 0

//        val parent = categoryDao.getById(parentId)
//            ?: throw CategoryException.ParentNotFound

//        val level = parent.level + 1

//        if (level > 2) {
//            throw CategoryException.TooDeepHierarchy
 //       }

 //      return level
  //  }
//}

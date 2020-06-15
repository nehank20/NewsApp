package com.poilkar.nehank.newsapp.db

import androidx.room.TypeConverter


class Converters {

    @TypeConverter
    fun fromSource(source: com.poilkar.nehank.newsapp.model.Source) : String {
        return source.name
    }

    @TypeConverter
    fun toSource(name : String) : com.poilkar.nehank.newsapp.model.Source {
        return com.poilkar.nehank.newsapp.model.Source(name, name)
    }



}
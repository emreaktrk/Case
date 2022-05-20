package com.emreaktrk.core

interface Mapper<I, O> {
    fun map(input: I): O
}

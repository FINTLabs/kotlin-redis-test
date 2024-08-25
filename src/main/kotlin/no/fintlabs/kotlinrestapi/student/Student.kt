package no.fintlabs.kotlinrestapi.student

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class Student(
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    val id: String = UUID.randomUUID().toString(),
    val name: String
)

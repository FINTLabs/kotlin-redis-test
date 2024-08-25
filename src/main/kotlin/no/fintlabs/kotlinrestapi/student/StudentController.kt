package no.fintlabs.kotlinrestapi.student

import no.fintlabs.kotlinrestapi.RedisService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class StudentController(
    val redisService: RedisService
) {

    private val log: Logger = LoggerFactory.getLogger(StudentController::class.java)

    @PostMapping
    suspend fun postStudent(@RequestBody student: Student): ResponseEntity<Student> {
        log.info("Student posted: {}", student)
        redisService.save(student.id, student)
        return ResponseEntity.ok(student)
    }

    @GetMapping("/{id}")
    suspend fun getStudent(@PathVariable id: String): ResponseEntity<Any> =
        ResponseEntity.ok(redisService.get(id))

}
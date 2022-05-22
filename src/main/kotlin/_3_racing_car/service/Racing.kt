package _3_racing_car.service

import _3_racing_car.service.dto.RacingInputDto
import _3_racing_car.service.dto.RacingOutputDto

class Racing {
    fun run(racingInput: RacingInputDto) =
        racingInput.tracks.associate { track ->
            val racer = track.run(racingInput.times)
            racer.name to racer.location
        }.let(::RacingOutputDto)
}

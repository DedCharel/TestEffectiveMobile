package ru.nvgsoft.testeffectivemobile.data

import ru.nvgsoft.testeffectivemobile.data.db.OfferDbModel
import ru.nvgsoft.testeffectivemobile.data.db.VacancyDbModel
import ru.nvgsoft.testeffectivemobile.data.network.dto.OfferDto
import ru.nvgsoft.testeffectivemobile.data.network.dto.VacancyDto
import ru.nvgsoft.testeffectivemobile.domain.entity.OfferModel
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyModel

class Mapper {

    fun mapDtoModelVacancyToEntity(dto: VacancyDto): VacancyModel {
        return VacancyModel(
            id = dto.id,
            lookingNumber = dto.lookingNumber,
            title = dto.title,
            addressTown = dto.address.town,
            addressStreet = dto.address.street,
            addressHouse = dto.address.house,
            company = dto.company,
            experiencePreviewText = dto.experience.previewText,
            experienceText = dto.experience.text,
            publishedDate = dto.publishedDate,
            isFavorite = dto.isFavorite,
            salaryFull = dto.salary.full,
            schedules = dto.schedules,
            appliedNumber = dto.appliedNumber,
            description = dto.description,
            responsibilities = dto.responsibilities,
            questions = dto.questions

        )
    }

    fun mapDtoModelOfferToEntity(dto: OfferDto): OfferModel {
        return OfferModel(
            id = dto.id,
            title = dto.title,
            link = dto.link,
            buttonText = dto.button?.text


        )
    }



    fun mapListDtoModelVacancyToListEntity(list: List<VacancyDto>): List<VacancyModel>{
        return list.map { mapDtoModelVacancyToEntity(it) }
    }

    fun mapListDtoModelOffersToListEntity(list: List<OfferDto>): List<OfferModel>{
        return list.map { mapDtoModelOfferToEntity(it) }
    }


    fun mapDtoVacancyToDbModel(dto: VacancyDto): VacancyDbModel{
        return VacancyDbModel(
            id = dto.id,
            lookingNumber = dto.lookingNumber,
            title = dto.title,
            addressTown = dto.address.town,
            addressStreet = dto.address.street,
            addressHouse = dto.address.house,
            company = dto.company,
            experiencePreviewText = dto.experience.previewText,
            experienceText = dto.experience.text,
            publishedDate = dto.publishedDate,
            isFavorite = dto.isFavorite,
            salaryFull = dto.salary.full,
            schedules = dto.schedules,
            appliedNumber = dto.appliedNumber,
            description = dto.description,
            responsibilities = dto.responsibilities,
            questions = dto.questions
        )
    }

    fun mapListDtoModelVacancyToDBList(list: List<VacancyDto>): List<VacancyDbModel>{
        return list.map { mapDtoVacancyToDbModel(it) }
    }

    fun mapDtoModelOfferToDbModel(dto: OfferDto): OfferDbModel {
        return OfferDbModel(
            id = dto.id,
            title = dto.title,
            link = dto.link,
            buttonText = dto.button?.text


        )
    }

    fun mapListDtoModelOfferToDBList(list: List<OfferDto>): List<OfferDbModel>{
        return list.map { mapDtoModelOfferToDbModel(it) }
    }
}
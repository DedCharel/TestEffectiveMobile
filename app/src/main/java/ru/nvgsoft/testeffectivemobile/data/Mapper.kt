package ru.nvgsoft.testeffectivemobile.data

import ru.nvgsoft.testeffectivemobile.data.database.OfferDbModel
import ru.nvgsoft.testeffectivemobile.data.database.VacancyDbModel
import ru.nvgsoft.testeffectivemobile.data.network.model.OfferDto
import ru.nvgsoft.testeffectivemobile.data.network.model.VacancyDto
import ru.nvgsoft.testeffectivemobile.domain.entity.OfferEntity
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyEntity
import javax.inject.Inject

class Mapper @Inject constructor() {

    fun mapDtoModelVacancyToEntity(dto: VacancyDto): VacancyEntity {
        return VacancyEntity(
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

    fun mapDbModelVacancyToEntity(dbModel: VacancyDbModel): VacancyEntity {
        return VacancyEntity(
            id = dbModel.id,
            lookingNumber = dbModel.lookingNumber,
            title = dbModel.title,
            addressTown = dbModel.addressTown,
            addressStreet = dbModel.addressStreet,
            addressHouse = dbModel.addressHouse,
            company = dbModel.company,
            experiencePreviewText = dbModel.experiencePreviewText,
            experienceText = dbModel.experienceText,
            publishedDate = dbModel.publishedDate,
            isFavorite = dbModel.isFavorite,
            salaryFull = dbModel.salaryFull,
            schedules = dbModel.schedules,
            appliedNumber = dbModel.appliedNumber,
            description = dbModel.description,
            responsibilities = dbModel.responsibilities,
            questions = dbModel.questions

        )
    }

    fun mapEntityVacancyToDbModel(entity: VacancyEntity): VacancyDbModel {
        return VacancyDbModel(
            id = entity.id,
            lookingNumber = entity.lookingNumber,
            title = entity.title,
            addressTown = entity.addressTown,
            addressStreet = entity.addressStreet,
            addressHouse = entity.addressHouse,
            company = entity.company,
            experiencePreviewText = entity.experiencePreviewText,
            experienceText = entity.experienceText,
            publishedDate = entity.publishedDate,
            isFavorite = entity.isFavorite,
            salaryFull = entity.salaryFull,
            schedules = entity.schedules,
            appliedNumber = entity.appliedNumber,
            description = entity.description,
            responsibilities = entity.responsibilities,
            questions = entity.questions

        )
    }

    fun mapDbModelOfferToEntity(dbModel: OfferDbModel): OfferEntity {
        return OfferEntity(
            id = dbModel.id,
            title = dbModel.title,
            link = dbModel.link,
            buttonText = dbModel.buttonText


        )
    }

    fun mapDtoModelOfferToEntity(dto: OfferDto): OfferEntity {
        return OfferEntity(
            id = dto.id,
            title = dto.title.trim(),
            link = dto.link,
            buttonText = dto.button?.text


        )
    }


    fun mapListDtoModelVacancyToListEntity(list: List<VacancyDto>): List<VacancyEntity>{
        return list.map { mapDtoModelVacancyToEntity(it) }
    }

    fun mapListDtoModelOffersToListEntity(list: List<OfferDto>): List<OfferEntity>{
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
            title = dto.title.trim(),
            link = dto.link,
            buttonText = dto.button?.text


        )
    }

    fun mapListDtoModelOfferToDBList(list: List<OfferDto>): List<OfferDbModel>{
        return list.map { mapDtoModelOfferToDbModel(it) }
    }

    fun mapListDbModelVacancyToEntityList(list: List<VacancyDbModel>): List<VacancyEntity>{
        return list.map { mapDbModelVacancyToEntity(it) }
    }

    fun mapListDbModelOfferToEntityList(list: List<OfferDbModel>): List<OfferEntity>{
        return list.map { mapDbModelOfferToEntity(it) }
    }
}
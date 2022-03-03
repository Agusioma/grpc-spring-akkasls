package pet.domain;

import com.akkaserverless.javasdk.valueentity.ValueEntityContext;
import com.google.protobuf.Empty;
import pet.api.PetApi;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
// This is the implementation for the Value Entity Service described in your pet/api/pet_api.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class Pet extends AbstractPet {
  @SuppressWarnings("unused")
  private final String entityId;

  public Pet(ValueEntityContext context) {
    this.entityId = context.entityId();
  }

  @Override
  public PetDomain.PetState emptyState() {
    throw new UnsupportedOperationException("Not implemented yet, replace with your empty entity state");
  }

  @Override
  public Effect<Empty> newAdoption(PetDomain.PetState currentState, PetApi.Pet pet) {
    PetDomain.PetState state = petDetailsDomainBuilder(pet);
    return effects().updateState(state).thenReply(Empty.getDefaultInstance());
  }

  private PetDomain.PetState petDetailsDomainBuilder(PetApi.Pet pet) {
    PetDomain.AdopterAddress adopterAddress = PetDomain.AdopterAddress.getDefaultInstance();
    if (pet.hasAdopterAddress()) {
      adopterAddress = adopterAddressDomainBuilder(pet.getAdopterAddress());
    }
    return PetDomain.PetState.newBuilder()
            .setPetId(pet.getPetId())
            .setAnimalType(pet.getAnimalType())
            .setDateOfAdoption(pet.getDateOfAdoption())
            .setPetGender(pet.getPetGender())
            .setVaccinationStatus(pet.getVaccinationStatus())
            .setAdopterName(pet.getAdopterName())
            .setAdopterAddress(adopterAddress)
            .build();
  }

  private PetDomain.AdopterAddress adopterAddressDomainBuilder(PetApi.AdopterAddress adopterAddress) {
    return PetDomain.AdopterAddress.newBuilder()
            .setStreetOrRoad(adopterAddress.getStreetOrRoad())
            .setHouseNumber(adopterAddress.getHouseNumber())
            .setCity(adopterAddress.getCity())
            .build();
  }

  @Override
  public Effect<PetApi.Pet> retrievePetDetails(PetDomain.PetState currentState, PetApi.GetPetRequest getPetRequest) {
    if (currentState.getPetId().equals("")) {
      return effects().error("Pet " + getPetRequest.getPetId() + " has not been created.");
    } else {
      return effects().reply(petApiBuilder(currentState));
    }
  }

  private PetApi.Pet petApiBuilder(PetDomain.PetState state) {
    PetApi.AdopterAddress adopterAddress = PetApi.AdopterAddress.getDefaultInstance();
    if (state.hasAdopterAddress()) {
      adopterAddress =
              PetApi.AdopterAddress.newBuilder()
                      .setStreetOrRoad(state.getAdopterAddress().getStreetOrRoad())
                      .setHouseNumber(state.getAdopterAddress().getHouseNumber())
                      .setCity(state.getAdopterAddress().getCity())
                      .build();
    }
    return PetApi.Pet.newBuilder()
            .setPetId(state.getPetId())
            .setAnimalType(state.getAnimalType())
            .setDateOfAdoption(state.getDateOfAdoption())
            .setPetGender(state.getPetGender())
            .setVaccinationStatus(state.getVaccinationStatus())
            .setAdopterName(state.getAdopterName())
            .setAdopterAddress(adopterAddress)
            .build();
  }

  @Override
  public Effect<Empty> editPetType(PetDomain.PetState currentState, PetApi.ChangeAnimalTypeRequest changeAnimalTypeRequest) {
    PetDomain.PetState updatedTypeState =
            currentState.toBuilder().setAnimalType(changeAnimalTypeRequest.getNewAnimalType()).build();
    return effects().updateState(updatedTypeState).thenReply(Empty.getDefaultInstance());
  }

  @Override
  public Effect<Empty> editPetGender(PetDomain.PetState currentState, PetApi.ChangeGenderRequest changeGenderRequest) {
    PetDomain.PetState updatedGenderState =
            currentState.toBuilder().setPetGender(changeGenderRequest.getNewPetGender() ).build();
    return effects().updateState(updatedGenderState).thenReply(Empty.getDefaultInstance());
  }

  @Override
  public Effect<Empty> editAdopterName(PetDomain.PetState currentState, PetApi.ChangeAdopterNameRequest changeAdopterNameRequest) {
    PetDomain.PetState updatedAdopterNameState =
            currentState.toBuilder().setAdopterName(changeAdopterNameRequest.getNewAdopterName()).build();
    return effects().updateState(updatedAdopterNameState).thenReply(Empty.getDefaultInstance());
  }

  @Override
  public Effect<Empty> editAdopterAddress(PetDomain.PetState currentState, PetApi.ChangeAdopterAddressRequest changeAdopterAddressRequest) {
    PetDomain.PetState updatedAdopterAddressState =
            currentState.toBuilder().setAdopterAddress(adopterAddressDomainBuilder(changeAdopterAddressRequest.getNewAdopterAddress())).build();
    return effects().updateState(updatedAdopterAddressState).thenReply(Empty.getDefaultInstance());
  }
}

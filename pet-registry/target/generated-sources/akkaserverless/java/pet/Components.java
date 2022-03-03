package pet;

import com.akkaserverless.javasdk.DeferredCall;

// This code is managed by Akka Serverless tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

/**
 * Not intended for user extension, provided through generated implementation
 */
public interface Components {
  PetCalls pet();
  PetByGenderViewCalls petByGenderView();

  interface PetCalls {
    DeferredCall<pet.api.PetApi.Pet, com.google.protobuf.Empty> newAdoption(pet.api.PetApi.Pet pet);

    DeferredCall<pet.api.PetApi.GetPetRequest, pet.api.PetApi.Pet> retrievePetDetails(pet.api.PetApi.GetPetRequest getPetRequest);

    DeferredCall<pet.api.PetApi.ChangeAnimalTypeRequest, com.google.protobuf.Empty> editPetType(pet.api.PetApi.ChangeAnimalTypeRequest changeAnimalTypeRequest);

    DeferredCall<pet.api.PetApi.ChangeGenderRequest, com.google.protobuf.Empty> editPetGender(pet.api.PetApi.ChangeGenderRequest changeGenderRequest);

    DeferredCall<pet.api.PetApi.ChangeAdopterNameRequest, com.google.protobuf.Empty> editAdopterName(pet.api.PetApi.ChangeAdopterNameRequest changeAdopterNameRequest);

    DeferredCall<pet.api.PetApi.ChangeAdopterAddressRequest, com.google.protobuf.Empty> editAdopterAddress(pet.api.PetApi.ChangeAdopterAddressRequest changeAdopterAddressRequest);
  }
  interface PetByGenderViewCalls {
    DeferredCall<pet.view.PetViewModel.ByGenderRequest, pet.domain.PetDomain.PetState> retrievePetByGender(pet.view.PetViewModel.ByGenderRequest byGenderRequest);
  }
}

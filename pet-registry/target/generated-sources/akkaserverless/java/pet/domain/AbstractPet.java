package pet.domain;

import com.akkaserverless.javasdk.valueentity.ValueEntity;
import com.google.protobuf.Empty;
import pet.Components;
import pet.ComponentsImpl;
import pet.api.PetApi;

// This code is managed by Akka Serverless tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

public abstract class AbstractPet extends ValueEntity<PetDomain.PetState> {

  protected final Components components() {
    return new ComponentsImpl(commandContext());
  }

  public abstract Effect<Empty> newAdoption(PetDomain.PetState currentState, PetApi.Pet pet);

  public abstract Effect<PetApi.Pet> retrievePetDetails(PetDomain.PetState currentState, PetApi.GetPetRequest getPetRequest);

  public abstract Effect<Empty> editPetType(PetDomain.PetState currentState, PetApi.ChangeAnimalTypeRequest changeAnimalTypeRequest);

  public abstract Effect<Empty> editPetGender(PetDomain.PetState currentState, PetApi.ChangeGenderRequest changeGenderRequest);

  public abstract Effect<Empty> editAdopterName(PetDomain.PetState currentState, PetApi.ChangeAdopterNameRequest changeAdopterNameRequest);

  public abstract Effect<Empty> editAdopterAddress(PetDomain.PetState currentState, PetApi.ChangeAdopterAddressRequest changeAdopterAddressRequest);

}

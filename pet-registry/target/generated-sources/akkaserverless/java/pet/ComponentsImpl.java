package pet;

import com.akkaserverless.javasdk.Context;
import com.akkaserverless.javasdk.DeferredCall;
import com.akkaserverless.javasdk.impl.DeferredCallImpl;
import com.akkaserverless.javasdk.impl.InternalContext;
import com.akkaserverless.javasdk.impl.MetadataImpl;

// This code is managed by Akka Serverless tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

/**
 * Not intended for direct instantiation, called by generated code, use Action.components() to access
 */
public final class ComponentsImpl implements Components {

  private final InternalContext context;

  public ComponentsImpl(Context context) {
    this.context = (InternalContext) context;
  }

  private <T> T getGrpcClient(Class<T> serviceClass) {
    return context.getComponentGrpcClient(serviceClass);
  }

  @Override
  public Components.PetCalls pet() {
    return new PetCallsImpl();
  }
  @Override
  public Components.PetByGenderViewCalls petByGenderView() {
    return new PetByGenderViewCallsImpl();
  }

  private final class PetCallsImpl implements Components.PetCalls {
     @Override
    public DeferredCall<pet.api.PetApi.Pet, com.google.protobuf.Empty> newAdoption(pet.api.PetApi.Pet pet) {
      return new DeferredCallImpl<>(
        pet,
        MetadataImpl.Empty(),
        "pet.api.PetService",
        "NewAdoption",
        () -> getGrpcClient(pet.api.PetService.class).newAdoption(pet)
      );
    }
    @Override
    public DeferredCall<pet.api.PetApi.GetPetRequest, pet.api.PetApi.Pet> retrievePetDetails(pet.api.PetApi.GetPetRequest getPetRequest) {
      return new DeferredCallImpl<>(
        getPetRequest,
        MetadataImpl.Empty(),
        "pet.api.PetService",
        "RetrievePetDetails",
        () -> getGrpcClient(pet.api.PetService.class).retrievePetDetails(getPetRequest)
      );
    }
    @Override
    public DeferredCall<pet.api.PetApi.ChangeAnimalTypeRequest, com.google.protobuf.Empty> editPetType(pet.api.PetApi.ChangeAnimalTypeRequest changeAnimalTypeRequest) {
      return new DeferredCallImpl<>(
        changeAnimalTypeRequest,
        MetadataImpl.Empty(),
        "pet.api.PetService",
        "EditPetType",
        () -> getGrpcClient(pet.api.PetService.class).editPetType(changeAnimalTypeRequest)
      );
    }
    @Override
    public DeferredCall<pet.api.PetApi.ChangeGenderRequest, com.google.protobuf.Empty> editPetGender(pet.api.PetApi.ChangeGenderRequest changeGenderRequest) {
      return new DeferredCallImpl<>(
        changeGenderRequest,
        MetadataImpl.Empty(),
        "pet.api.PetService",
        "EditPetGender",
        () -> getGrpcClient(pet.api.PetService.class).editPetGender(changeGenderRequest)
      );
    }
    @Override
    public DeferredCall<pet.api.PetApi.ChangeAdopterNameRequest, com.google.protobuf.Empty> editAdopterName(pet.api.PetApi.ChangeAdopterNameRequest changeAdopterNameRequest) {
      return new DeferredCallImpl<>(
        changeAdopterNameRequest,
        MetadataImpl.Empty(),
        "pet.api.PetService",
        "EditAdopterName",
        () -> getGrpcClient(pet.api.PetService.class).editAdopterName(changeAdopterNameRequest)
      );
    }
    @Override
    public DeferredCall<pet.api.PetApi.ChangeAdopterAddressRequest, com.google.protobuf.Empty> editAdopterAddress(pet.api.PetApi.ChangeAdopterAddressRequest changeAdopterAddressRequest) {
      return new DeferredCallImpl<>(
        changeAdopterAddressRequest,
        MetadataImpl.Empty(),
        "pet.api.PetService",
        "EditAdopterAddress",
        () -> getGrpcClient(pet.api.PetService.class).editAdopterAddress(changeAdopterAddressRequest)
      );
    }
  }
  private final class PetByGenderViewCallsImpl implements Components.PetByGenderViewCalls {
     @Override
    public DeferredCall<pet.view.PetViewModel.ByGenderRequest, pet.domain.PetDomain.PetState> retrievePetByGender(pet.view.PetViewModel.ByGenderRequest byGenderRequest) {
      return new DeferredCallImpl<>(
        byGenderRequest,
        MetadataImpl.Empty(),
        "pet.view.PetByGender",
        "RetrievePetByGender",
        () -> getGrpcClient(pet.view.PetByGender.class).retrievePetByGender(byGenderRequest)
      );
    }
  }
}

package pet.domain;

import com.akkaserverless.javasdk.impl.valueentity.ValueEntityRouter;
import com.akkaserverless.javasdk.valueentity.CommandContext;
import com.akkaserverless.javasdk.valueentity.ValueEntity;
import com.google.protobuf.Empty;
import pet.api.PetApi;

// This code is managed by Akka Serverless tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

/**
 * A value entity handler that is the glue between the Protobuf service <code>PetService</code>
 * and the command handler methods in the <code>Pet</code> class.
 */
public class PetRouter extends ValueEntityRouter<PetDomain.PetState, Pet> {

  public PetRouter(Pet entity) {
    super(entity);
  }

  @Override
  public ValueEntity.Effect<?> handleCommand(
      String commandName, PetDomain.PetState state, Object command, CommandContext context) {
    switch (commandName) {

      case "NewAdoption":
        return entity().newAdoption(state, (PetApi.Pet) command);

      case "RetrievePetDetails":
        return entity().retrievePetDetails(state, (PetApi.GetPetRequest) command);

      case "EditPetType":
        return entity().editPetType(state, (PetApi.ChangeAnimalTypeRequest) command);

      case "EditPetGender":
        return entity().editPetGender(state, (PetApi.ChangeGenderRequest) command);

      case "EditAdopterName":
        return entity().editAdopterName(state, (PetApi.ChangeAdopterNameRequest) command);

      case "EditAdopterAddress":
        return entity().editAdopterAddress(state, (PetApi.ChangeAdopterAddressRequest) command);

      default:
        throw new ValueEntityRouter.CommandHandlerNotFound(commandName);
    }
  }
}

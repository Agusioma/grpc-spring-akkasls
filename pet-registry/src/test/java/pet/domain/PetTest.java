package pet.domain;

import com.akkaserverless.javasdk.testkit.ValueEntityResult;
import com.akkaserverless.javasdk.valueentity.ValueEntity;
import com.google.protobuf.Empty;
import org.junit.Test;
import pet.api.PetApi;

import static org.junit.Assert.*;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class PetTest {

  @Test
  public void exampleTest() {
    PetTestKit testKit = PetTestKit.of(Pet::new);
    // use the testkit to execute a command
    // of events emitted, or a final updated state:
    // ValueEntityResult<SomeResponse> result = testKit.someOperation(SomeRequest);
    // verify the response
    // SomeResponse actualResponse = result.getReply();
    // assertEquals(expectedResponse, actualResponse);
    // verify the final state after the command
    // assertEquals(expectedState, testKit.getState());
  }

  @Test
  public void newAdoptionTest() {
    PetTestKit testKit = PetTestKit.of(Pet::new);
    // ValueEntityResult<Empty> result = testKit.newAdoption(Pet.newBuilder()...build());
  }


  @Test
  public void retrievePetDetailsTest() {
    PetTestKit testKit = PetTestKit.of(Pet::new);
    // ValueEntityResult<Pet> result = testKit.retrievePetDetails(GetPetRequest.newBuilder()...build());
  }


  @Test
  public void editPetTypeTest() {
    PetTestKit testKit = PetTestKit.of(Pet::new);
    // ValueEntityResult<Empty> result = testKit.editPetType(ChangeAnimalTypeRequest.newBuilder()...build());
  }


  @Test
  public void editPetGenderTest() {
    PetTestKit testKit = PetTestKit.of(Pet::new);
    // ValueEntityResult<Empty> result = testKit.editPetGender(ChangeGenderRequest.newBuilder()...build());
  }


  @Test
  public void editAdopterNameTest() {
    PetTestKit testKit = PetTestKit.of(Pet::new);
    // ValueEntityResult<Empty> result = testKit.editAdopterName(ChangeAdopterNameRequest.newBuilder()...build());
  }


  @Test
  public void editAdopterAddressTest() {
    PetTestKit testKit = PetTestKit.of(Pet::new);
    // ValueEntityResult<Empty> result = testKit.editAdopterAddress(ChangeAdopterAddressRequest.newBuilder()...build());
  }

}

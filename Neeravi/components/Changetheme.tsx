import { Button, color, HStack, useColorMode } from "@chakra-ui/react";
import { Switch } from "@chakra-ui/react";

function Changetheme() {
  let { colorMode, toggleColorMode } = useColorMode();
  return (
      <HStack align="center" direction="row">
        <Switch size="lg" isChecked={colorMode==="dark"}  onChange={toggleColorMode} ></Switch>
        <p style={{ color: "white" }}>Darkmode</p>
      </HStack>
    
  );
}

export default Changetheme;

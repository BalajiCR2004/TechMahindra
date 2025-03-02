import { 
    Drawer, DrawerOverlay, DrawerContent, DrawerCloseButton, DrawerHeader, DrawerBody, VStack, Button
  } from "@chakra-ui/react";
  import Panels from "./Panels";
  
  interface SidebarProps {
    isOpen: boolean;
    onClose: () => void;
  }
  
  const GameDrawer: React.FC<SidebarProps> = ({ isOpen, onClose }) => {
    return (
      <Drawer isOpen={isOpen} placement="left" onClose={onClose}>
        <DrawerOverlay />
        <DrawerContent bg={"#1e7197"}>
          <DrawerCloseButton />
          <DrawerHeader color="white">Menu</DrawerHeader>
          <DrawerBody>
            <VStack spacing={4}>
              <Panels />
              <Button colorScheme="red" onClick={onClose}>Close</Button>
            </VStack>
          </DrawerBody>
        </DrawerContent>
      </Drawer>
    );
  };
  
  export default GameDrawer;
  
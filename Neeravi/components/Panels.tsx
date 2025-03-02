import { 
  Button, 
  Tab, 
  TabList, 
  TabPanel, 
  TabPanels, 
  Tabs, 
  VStack, 
  Text, 
  Input 
} from "@chakra-ui/react";
import React from "react";

const Panels = () => {
  return (
    <Tabs variant="soft-rounded" colorScheme="teal" isFitted>
      {/* Tab Navigation */}
      <TabList>
        <Tab>❓ Help</Tab>
        <Tab>🔑 Sign In</Tab>
        <Tab>ℹ️ About</Tab>
      </TabList>

      {/* Tab Content */}
      <TabPanels>
        {/* Help Panel */}
        <TabPanel>
          <VStack spacing={4} align="start">
            <Text fontWeight="bold">Need Help?</Text>
            <Button colorScheme="red" w="full">Game Guide</Button>
            <Button colorScheme="red" w="full">Support Center</Button>
            <Button colorScheme="red" w="full">Community Forum</Button>
          </VStack>
        </TabPanel>

        {/* Sign In Panel */}
        <TabPanel>
          <VStack spacing={4} align="start">
            <Text fontWeight="bold">Sign In</Text>
            <Input placeholder="Enter your email" size="md" />
            <Input placeholder="Enter your password" type="password" size="md" />
            <Button colorScheme="teal" w="full">Sign In</Button>
          </VStack>
        </TabPanel>

        {/* About Panel */}
        <TabPanel>
          <VStack spacing={4} align="start">
            <Text fontWeight="bold">About This App</Text>
            <Text fontSize="sm">
              This is a gaming portal that provides access to popular games, settings, and support. 
              Developed with Chakra UI for an interactive experience.
            </Text>
          </VStack>
        </TabPanel>
      </TabPanels>
    </Tabs>
  );
};

export default Panels;

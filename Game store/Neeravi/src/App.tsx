import { useState } from "react"; 
import { Grid, GridItem, Text, useColorModeValue, Box, Button, Slide, CloseButton } from "@chakra-ui/react"; 
import Navbar from "../components/Navbar"; 
import GameCard from "../components/GameCard"; 
import Panels from "../components/Panels"; 
import Footer from "../components/Footer";  

function App() {   
  const [isOpen, setIsOpen] = useState(false);    

  // Adjusted Modern Color Palette   
  const bgColor = useColorModeValue("#fdfdfd", "#0d1117"); // Warm white or dark mode  
  const navBg = useColorModeValue("#2b6cb0", "#161b22"); // Vibrant blue or dark navy  
  const sideBg = useColorModeValue("#cbd5e0", "#1f2937"); // Light gray-blue or dark gray  
  const mainBg = useColorModeValue("#edf2f7", "#21262d"); // Soft pastel gray or steel blue  
  const btnColor = useColorModeValue("blue.500", "blue.300"); // Brighter blue   

  return (     
    <Box bg={bgColor} minH="100vh" p={4} position="relative">       
      <Grid         
        templateAreas={`"nav" "main"`}
        gridTemplateRows={"auto 1fr"}          
        gridTemplateColumns={"1fr"}          
        gap={6}       
      >         
        {/* Navigation Bar */}         
        <GridItem            
          area={'nav'}            
          bg={navBg}            
          p={4}            
          borderRadius="lg"            
          boxShadow="xl"            
          display="flex"            
          justifyContent="space-between"            
          alignItems="center"         
        >           
          <Button colorScheme="blue" onClick={() => setIsOpen(true)}>Menu</Button>           
          <Text color="white" fontSize="2xl" fontWeight="bold">🎮 NEERAVI</Text>            
          <Navbar />         
        </GridItem>          

        {/* Main Content */}         
        <GridItem            
          area={'main'}            
          bg={mainBg}            
          p={6}            
          borderRadius="lg"            
          boxShadow="xl"         
        >           
          <GameCard />           
          <Footer />         
        </GridItem>       
      </Grid>        

      {/* Sidebar Filter (Slide-in from the left) */}       
      <Slide direction="left" in={isOpen} style={{ zIndex: 20, position: "fixed", left: 0, top: 0, height: "100vh" }}>         
        <Box            
          w="320px"            
          bg={sideBg}            
          p={6}            
          h="100vh"            
          boxShadow="dark-lg"            
          position="fixed"            
          left={0}            
          top={0}            
          borderRightRadius="lg"         
        >           
          {/* Close Button */}           
          <CloseButton onClick={() => setIsOpen(false)} position="absolute" top="10px" right="10px" />            
          <Panels />         
        </Box>       
      </Slide>     
    </Box>   
  ); 
}  

export default App;

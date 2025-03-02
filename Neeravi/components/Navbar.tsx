import { Stack, HStack, VStack, Image, Switch, Flex } from '@chakra-ui/react'
import logo from '../src/assets/steam-icon-14883.png'
import { color, px } from 'framer-motion';
import Changetheme from './Changetheme';
function Navbar(){
    return(<HStack justifyContent={"space-between"} padding={"10px"}>
        <Image src={logo} boxSize={"60px"}></Image>
        <Changetheme />
        </HStack>);      
}
export default Navbar;
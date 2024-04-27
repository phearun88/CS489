import React, { useEffect, useState } from "react";

const DashboardScreen = () => {
    // const [reloadOnce, setReloadOnce] = useState(false);

    // useEffect(() => {

    //     if (!reloadOnce) {

    //         setReloadOnce(true);
    //         console.log("ds" +true)
    //         // window.location.reload();
    //     }

    // }, [reloadOnce]);
    const [reloadCount, setReloadCount] = useState(0);
    useEffect(() => {

        handleReload();

    }, []);
    const handleReload = () => {
        if (reloadCount < 1) {
            // window.location.reload();
            setReloadCount(reloadCount + 1);
            console.log(reloadCount)
        }
    };

    return (
        <>
            <div>
                <h1 className="text-3xl font-bold text-gray-800 mb-2 mt-4  mr-10  border-gray-900 border-b-4" b>Dashboard</h1>
                <div className="mb-2">


                </div>


                <div class="flex">
                   
                    <div class="max-w-xs mx-2 bg-white shadow-md rounded-lg overflow-hidden">
                            
                            <div class="p-4">
                                <h2 class="font-bold text-xl mb-2">Card Title 1</h2>
                                <p class="text-gray-700">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                            </div>
                    </div>

                  
                    <div class="max-w-xs mx-2 bg-white shadow-md rounded-lg overflow-hidden">
                     
                            <div class="p-4">
                                <h2 class="font-bold text-xl mb-2">Card Title 2</h2>
                                <p class="text-gray-700">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                            </div>
                    </div>

                    
                    <div class="max-w-xs mx-2 bg-white shadow-md rounded-lg overflow-hidden">
                        
                            <div class="p-4">
                                <h2 class="font-bold text-xl mb-2">Card Title 3</h2>
                                <p class="text-gray-700">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                            </div>
                    </div>
                </div>



            </div>
        </>
    );
}

export default DashboardScreen;
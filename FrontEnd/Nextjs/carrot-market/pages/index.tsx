import type {NextPage} from "next";

const Home: NextPage = () => {
    return (
        <div className="bg-slate-400 py-20 px-20 flex flex-col space-y-5">
            <div className="bg-white p-5 rounded-2xl shadow-xl">
                <span className="font-semibold text-3xl">Select Item</span>
                <div className="flex justify-between my-2">
                    <span className="text-gray-500">Grey Chair</span>
                    <span className="font-semibold">$19</span>
                </div>
                <div className="flex justify-between my-2">
                    <span className="text-gray-500">Tooly Table</span>
                    <span className="font-semibold">$80</span>
                </div>
                <div className="flex justify-between mt-2 pt-2 border-t-4 border-dashed">
                    <span>Total</span>
                    <span className="font-semibold">$99</span>
                </div>
                <div className="mt-5 mx-auto bg-blue-500 text-white p-5 text-center rounded-2xl w-1/2">Checkout</div>
            </div>
            <div className="bg-white overflow-hidden rounded-2xl shadow-xl">
                <div className="bg-blue-500 p-6 pb-14">
                    <span className="text-white text-2xl">Profile</span>
                </div>
                <div className="rounded-3xl p-6 bg-white relative -top-5">
                    <div className="flex relative -top-16 items-end justify-between">
                        <div className="flex flex-col items-center">
                            <span className="text-sm text-gray-500">Orders</span>
                            <span className="font-medium">$340</span>
                        </div>
                        <div className="h-24 w-24 bg-red-400 rounded-full"/>
                        <div className="flex flex-col items-center">
                            <span className="text-sm text-gray-500">Spent</span>
                            <span className="font-medium">$340</span>
                        </div>
                    </div>
                    <div className="relative -mt-10 -mb-5 flex flex-col items-center">
                        <span className="text-lg font-medium">Tony Molloy</span>
                        <span className="text-sm text-gray-500">New York, USA</span>
                    </div>
                </div>
            </div>
            <div className="bg-white p-10 rounded-2xl shadow-xl"></div>
            <div className="bg-white p-10 rounded-2xl shadow-xl"></div>
        </div>
    )
};

export default Home;
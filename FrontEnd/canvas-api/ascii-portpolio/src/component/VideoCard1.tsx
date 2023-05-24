import styled from "styled-components";
// @ts-ignore
import video1 from "../asset/video/video1.mp4";
import {useEffect, useRef} from "react";
import {applyImageFilter} from "../util/filter/filter";
import NoiseFilter from "../util/filter/NoiseFilter";

const VideoCard1 = () => {
    const videoRef = useRef<HTMLVideoElement>(null);
    const filterRef = useRef<HTMLCanvasElement>(null);

    useEffect(() => {
        const video = videoRef.current;
        const filter = filterRef.current;
        const context = filter?.getContext("2d", {alpha: false});
        if (video && filter && context) {
            let noise = 0;

            video.addEventListener("play", () => {
                draw(video, context, filter.width, filter.height);
                window.addEventListener("keypress", (e) => {
                    if (e.key === "a") {
                        if (noise < 100) {
                            noise++;
                        }
                    } else if (e.key === "s") {
                        if (noise > 0) {
                            noise--;
                        }
                    }
                })
            })

            const draw = (video: HTMLVideoElement, context: CanvasRenderingContext2D, width: number, height: number) => {
                context.drawImage(video, 0, 0, width, height);
                const image = context.getImageData(0, 0, width, height);
                applyImageFilter(image, NoiseFilter({percent: noise}));
                context.putImageData(image, 0, 0);
                requestAnimationFrame(() => draw(video, context, width, height));
                // setInterval(() => draw(video, context, width, height), 2000);
            }
        }


    }, []);

    return (
        <Container>
            <Video src={video1} muted loop autoPlay ref={videoRef}/>
            <Filter ref={filterRef}/>
        </Container>
    )
}

const Container = styled.div`
  position: relative;
  width: 300px;
  height: 300px;
`;

const Video = styled.video`
  position: absolute;
  top: 0;
  left: 0;

  width: 100%;
  height: 100%;
  //visibility: hidden;
  opacity: 0;
`

const Filter = styled.canvas`
  position: absolute;
  top: 0;
  left: 0;

  width: 100%;
  height: 100%;
`
export default VideoCard1;